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

package org.springframework.session.data.gemfire.support;

import java.time.Duration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.session.SessionRepository;

/**
 * The FixedDurationExpirationSessionRepositoryBeanPostProcessor class...
 *
 * @author John Blum
 * @since 1.0.0
 */
@SuppressWarnings("unused")
public class FixedDurationExpirationSessionRepositoryBeanPostProcessor implements BeanPostProcessor {

	private final Duration expirationDuration;

	public FixedDurationExpirationSessionRepositoryBeanPostProcessor(Duration expirationDuration) {
		this.expirationDuration = expirationDuration;
	}

	@Nullable @Override @SuppressWarnings("unchecked")
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		return (bean instanceof SessionRepository
			? new FixedDurationExpirationSessionRepository<>((SessionRepository) bean, this.expirationDuration)
			: bean);

	}
}
