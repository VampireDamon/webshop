package com.damon.bgmt;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String VERSION = "1.0";

    @Value("${auth-server-url}")
    String authServerUrl;

    @Value("${auth-token-url}")
    String authTokenUrl;

    @Value("${auth-authorize-url}")
    String authAuthorizeUrl;

    @Value("${info.app.desc:接口文档}")
    private String serviceDesc;

    @Value("${spring.application.name}")
    private String serviceName;

    @Value("${security.oauth2.client.client-id:client_1}")
    String clientId;

    @Value("${security.oauth2.client.client-secret:123456}")
    String clientSecret;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(serviceName + serviceDesc)
                .description("测试版本")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .contact(new Contact("damon", "", "715645233@qq.com"))
                .version(VERSION)
                .build();
    }

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.damon"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Lists.newArrayList(oauth()))
                .securityContexts(Lists.newArrayList(securityContext()));
    }

    private SecurityScheme oauth() {
        return new OAuthBuilder()
                .name("oauth2")
                .scopes(scopes())
                .grantTypes(grantTypes())
                .build();
    }

    private List<AuthorizationScope> scopes() {
        List<AuthorizationScope> list = new ArrayList<>();
        list.add(new AuthorizationScope("read", "Grants read access"));
        list.add(new AuthorizationScope("write", "Grants write access"));
        list.add(new AuthorizationScope("all", "Grants all access"));
        return list;
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        return Lists.newArrayList(
                new SecurityReference("oauth2", scopes().toArray(new AuthorizationScope[0])));
    }

    @Bean
    List<GrantType> grantTypes() {
        List<GrantType> grantTypes = new ArrayList<>();
        ClientCredentialsGrant clientCredentialsGrant = new ClientCredentialsGrant(authTokenUrl);
        ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant =
                new ResourceOwnerPasswordCredentialsGrant(authTokenUrl);
        AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant(new TokenRequestEndpoint(authAuthorizeUrl
                , "clientId", "clientSecret"), new TokenEndpoint(authTokenUrl, "access_token"));
        ImplicitGrant implicitGrant = new ImplicitGrant(new LoginEndpoint(authTokenUrl), "access_token");
        grantTypes.add(resourceOwnerPasswordCredentialsGrant);
        grantTypes.add(implicitGrant);
        grantTypes.add(authorizationCodeGrant);
        grantTypes.add(clientCredentialsGrant);
        return grantTypes;
    }
/*    @Bean
    List<GrantType> grantTypes() {
        List<GrantType> grantTypes = new ArrayList<>();
        TokenRequestEndpoint tokenRequestEndpoint = new TokenRequestEndpoint(
                keycloakProperties.getClient().getUserAuthorizationUri(),
                keycloakProperties.getClient().getClientId(), keycloakProperties.getClient().getClientSecret());
        TokenEndpoint tokenEndpoint = new TokenEndpoint(keycloakProperties.getClient().getAccessTokenUri(), "access_token");
        grantTypes.add(new AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint));
        return grantTypes;
    }*/

    @Bean
    public SecurityConfiguration securityInfo() {
        return SecurityConfigurationBuilder.builder()
                .appName(serviceName)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .scopeSeparator(",")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    }
}