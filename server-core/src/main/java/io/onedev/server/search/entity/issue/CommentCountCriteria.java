package io.onedev.server.search.entity.issue;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import io.onedev.server.model.Issue;

import io.onedev.server.util.query.IssueQueryConstants;

public class CommentCountCriteria extends IssueCriteria {

	private static final long serialVersionUID = 1L;

	private final int operator;
	
	private final int value;
	
	public CommentCountCriteria(int value, int operator) {
		this.operator = operator;
		this.value = value;
	}

	@Override
	public Predicate getPredicate(Root<Issue> root, CriteriaBuilder builder) {
		Path<Integer> attribute = root.get(IssueQueryConstants.ATTR_COMMENT_COUNT);
		if (operator == IssueQueryLexer.Is)
			return builder.equal(attribute, value);
		else if (operator == IssueQueryLexer.IsGreaterThan)
			return builder.greaterThan(attribute, value);
		else
			return builder.lessThan(attribute, value);
	}

	@Override
	public boolean matches(Issue issue) {
		if (operator == IssueQueryLexer.Is)
			return issue.getCommentCount() == value;
		else if (operator == IssueQueryLexer.IsGreaterThan)
			return issue.getCommentCount() > value;
		else
			return issue.getCommentCount() < value;
	}

	@Override
	public String asString() {
		return quote(IssueQueryConstants.FIELD_COMMENT_COUNT) + " " 
				+ IssueQuery.getRuleName(operator) + " " 
				+ quote(String.valueOf(value));
	}

}
