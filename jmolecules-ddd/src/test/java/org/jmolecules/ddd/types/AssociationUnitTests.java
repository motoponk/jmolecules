/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jmolecules.ddd.types;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssociationUnitTests {

	@Test
	void createsAssociationFromIdentifier() {

		SampleAggregateIdentifier id = new SampleAggregateIdentifier();

		assertThat(Association.forId(id).getId()).isEqualTo(id);
	}

	@Test
	void createsAssoctionFromAggregate() {

		SampleAggregateIdentifier identifier = new SampleAggregateIdentifier();
		SampleAggregate aggregate = new SampleAggregate(identifier);

		assertThat(Association.forAggregate(aggregate).getId()).isEqualTo(identifier);
	}

	@Test
	void rejectsNullIdentifier() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Association.forId(null));
	}

	@Test
	void rejectsNullAggregate() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Association.forAggregate(null));
	}

	static class SampleAggregateIdentifier implements Identifier {}

	static class SampleAggregate implements AggregateRoot<SampleAggregate, SampleAggregateIdentifier> {

		private final SampleAggregateIdentifier id;

		SampleAggregate(SampleAggregateIdentifier id) {
			this.id = id;
		}

		/*
		 * (non-Javadoc)
		 * @see org.jmolecules.ddd.types.Identifiable#getId()
		 */
		@Override
		public SampleAggregateIdentifier getId() {
			return id;
		}
	}
}
