package io.onedev.server.web.component.user.choice;

import java.util.List;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

import io.onedev.server.web.page.base.BaseDependentResourceReference;

public class UserChoiceResourceReference extends BaseDependentResourceReference {

	private static final long serialVersionUID = 1L;

	public UserChoiceResourceReference() {
		super(UserChoiceResourceReference.class, "user-choice.js");
	}

	@Override
	public List<HeaderItem> getDependencies() {
		List<HeaderItem> dependencies = super.getDependencies();
		dependencies.add(CssHeaderItem.forReference(
				new CssResourceReference(UserChoiceResourceReference.class, "user-choice.css")));
		return dependencies;
	}

}
