/*
 * Copyright 2001-2012 Software Engineering Center Chinese Academy of Sciences.
 * All rights reserved. SEC PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */
package com.uk.sec.framework.example.qurtzjob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.uk.sec.framework.log.LogFactory;


/**
 * @author xzw.
 * @since 1.0
 * @version 1.0
 */
public class ExampleJob extends QuartzJobBean implements org.quartz.Job {
    
    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        LogFactory.LOGGER_FRAMEWORK.info("Quartz:Example job run.");
        
    }
}
