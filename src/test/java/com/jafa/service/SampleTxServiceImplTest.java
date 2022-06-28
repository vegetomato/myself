package com.jafa.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jafa.config.Apptest;

public class SampleTxServiceImplTest extends Apptest{

	@Autowired
	SampleTxServiceImpl impl;
	
	@Test
	public void test() {
		impl.addData("HELLOWORLD");
		
	}

}
