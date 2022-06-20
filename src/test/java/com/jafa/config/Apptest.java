package com.jafa.config;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class Apptest {

}
