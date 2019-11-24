package com.damon.bgmt.service.impl;

import com.damon.bgmt.DAO.SysUserDAO;
import com.damon.bgmt.domain.SysUser;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.SysLoginService;
import com.damon.bgmt.service.SysUserService;
import com.damon.bgmt.utils.DamonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysLoginServiceImpl implements SysLoginService {

    private static final Logger logger = LoggerFactory.getLogger(SysLoginServiceImpl.class);


}
