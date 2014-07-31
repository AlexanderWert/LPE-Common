package org.aim.description.builder;

import org.aim.description.restrictions.Restriction;

/**
 * Builder for a {@link Restriction}.
 * 
 * @author Henning Schulz
 * 
 * @param <B>
 *            {@link AbstractRestrictableBuilder} builder class which the caller is of.
 */
public class RestrictionBuilder<B extends AbstractRestrictableBuilder> {

	private final B parentBuilder;

	private final Restriction restriction;

	/**
	 * Constructor.
	 * 
	 * @param parentBuilder
	 *            builder which called this constructor.
	 * @param restriction 
	 */
	public RestrictionBuilder(B parentBuilder, Restriction restriction) {
		this.parentBuilder = parentBuilder;
		this.restriction = restriction;
	}

	/**
	 * Includes the specified package.
	 * 
	 * @param packageName
	 *            package to be included
	 * @return this builder
	 */
	public RestrictionBuilder<B> includePackage(String packageName) {
		restriction.addPackageInclude(packageName);
		return this;
	}

	/**
	 * Excludes the specified package.
	 * 
	 * @param packageName
	 *            package to be excluded
	 * @return this builder
	 */
	public RestrictionBuilder<B> excludePackage(String packageName) {
		restriction.addPackageExclude(packageName);
		return this;
	}

	/**
	 * Includes all methods with the specified modifier.
	 * 
	 * @param modifier
	 *            modifier of the methods to be included
	 * @return this builder
	 */
	public RestrictionBuilder<B> includeModifier(int modifier) {
		restriction.addModifierInclude(modifier);
		return this;
	}

	/**
	 * Excludes all methods with the specified modifier.
	 * 
	 * @param modifier
	 *            modifier of the methods to be excluded
	 * @return this builder
	 */
	public RestrictionBuilder<B> excludeModifier(int modifier) {
		restriction.addModifierExclude(modifier);
		return this;
	}

	/**
	 * Finishes building of this restriction and returns to the parent builder.
	 * 
	 * @return the parent builder
	 */
	public B restrictionDone() {
		parentBuilder.setRestriction(restriction);
		return parentBuilder;
	}

}
