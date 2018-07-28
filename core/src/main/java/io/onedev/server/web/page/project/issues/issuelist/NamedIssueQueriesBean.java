package io.onedev.server.web.page.project.issues.issuelist;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import io.onedev.server.model.support.issue.NamedIssueQuery;
import io.onedev.server.web.editable.annotation.Editable;
import io.onedev.server.web.editable.annotation.OmitName;
import io.onedev.server.web.page.project.savedquery.NamedQueriesBean;

@Editable
public class NamedIssueQueriesBean extends NamedQueriesBean<NamedIssueQuery> {

	private static final long serialVersionUID = 1L;

	private List<NamedIssueQuery> queries = new ArrayList<>();

	@NotNull
	@Editable
	@OmitName
	public List<NamedIssueQuery> getQueries() {
		return queries;
	}

	public void setQueries(List<NamedIssueQuery> queries) {
		this.queries = queries;
	}

}