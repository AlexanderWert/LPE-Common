/**
 * Copyright 2014 SAP AG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aim.description.scopes;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * This scope contains all methods of all traces rooting from the methods in the
 * given sub-scope.
 * 
 * @author Henning Schulz
 * 
 */
public class TraceScope extends MethodsEnclosingScope {

	private final MethodsEnclosingScope subScope;

	/**
	 * Constructor.
	 * 
	 * @param subScope
	 *            scope of root methods
	 */
	@JsonCreator
	public TraceScope(@JsonProperty("subScope") MethodsEnclosingScope subScope, long id) {
		super(id);
		this.subScope = subScope;
	}
	
	@JsonCreator
	public TraceScope(@JsonProperty("subScope") MethodsEnclosingScope subScope) {
		this(subScope, System.nanoTime());
	}

	@Override
	public String toString() {
		return "Trace Scope [" + getSubScope().toString() + "]";
	}

	public MethodsEnclosingScope getSubScope() {
		return subScope;
	}

}
