/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.greglturnquist.learningspringboot.webdriver;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;


// tag::code[]
class FirefoxDriverFactory implements ObjectFactory<FirefoxDriver> {

	private WebDriverConfigurationProperties properties;

	FirefoxDriverFactory(WebDriverConfigurationProperties properties) {
		this.properties = properties;
	}

	@Override
	public FirefoxDriver getObject() throws BeansException {
		if (properties.getFirefox().isEnabled()) {
			try {
				return new FirefoxDriver();
			} catch (WebDriverException e) {
				e.printStackTrace();
				// swallow the exception
			}
		}
		return null;
	}
}
// end::code[]
