/*
 * Copyright 2020-2021 the original author or authors.
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
package org.jmolecules.ddd.types;

/**
 * An association to an {@link AggregateRoot}.
 *
 * @author Christian Stettler
 * @author Henning Schwentner
 * @author Stephan Pirnbaum
 * @author Martin Schimak
 * @author John Sullivan
 * @author Oliver Drotbohm
 * @see <a href="https://scabl.blogspot.com/2015/04/aeddd-9.html>John Sullivan - Advancing Enterprise DDD - Reinstating
 *      the Aggregate</a>
 */
public interface Association<T extends AggregateRoot<T, ID>, ID extends Identifier> extends Identifiable<ID> {

	/**
	 * Creates an {@link Association} pointing to the {@link Identifier} of the given {@link AggregateRoot}.
	 *
	 * @param <T> the concrete {@link AggregateRoot} type.
	 * @param <ID> the concrete {@link Identifier} type.
	 * @param aggregate must not be {@literal null}.
	 * @return an {@link Association} pointing to the {@link Identifier} of the given {@link AggregateRoot}, will never be
	 *         {@literal null}.
	 * @since 1.2
	 */
	static <T extends AggregateRoot<T, ID>, ID extends Identifier> Association<T, ID> forAggregate(T aggregate) {

		if (aggregate == null) {
			throw new IllegalArgumentException("Aggregate must not be null!");
		}

		return () -> aggregate.getId();
	}

	/**
	 * Creates an {@link Association} pointing to the given {@link Identifier}.
	 *
	 * @param <T> the concrete {@link AggregateRoot} type.
	 * @param <ID> the concrete {@link Identifier} type.
	 * @param identifier must not be {@literal null}.
	 * @return an {@link Association} pointing to the given {@link Identifier}, will never be {@literal null}.
	 * @since 1.2
	 */
	static <T extends AggregateRoot<T, ID>, ID extends Identifier> Association<T, ID> forId(ID identifier) {

		if (identifier == null) {
			throw new IllegalArgumentException("Identifier must not be null!");
		}

		return () -> identifier;
	}
}
