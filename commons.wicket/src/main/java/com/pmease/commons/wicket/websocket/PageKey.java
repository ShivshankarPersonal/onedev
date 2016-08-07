package com.pmease.commons.wicket.websocket;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.ws.api.registry.IKey;
import org.apache.wicket.protocol.ws.api.registry.PageIdKey;

public class PageKey {
	
	private final String sessionId;
	
	private final IKey pageId;
	
	public PageKey(String sessionId, IKey pageId) {
		this.sessionId = sessionId;
		this.pageId = pageId;
	}
	
	public PageKey(String sessionId, Integer pageId) {
		this.sessionId = sessionId;
		this.pageId = new PageIdKey(pageId);
	}
	
	public PageKey(Page page) {
		this.sessionId = page.getSession().getId();
		this.pageId = new PageIdKey(page.getPageId());
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof PageKey))
			return false;
		if (this == other)
			return true;
		PageKey otherKey = (PageKey) other;
		return new EqualsBuilder()
				.append(sessionId, otherKey.sessionId)
				.append(pageId, otherKey.pageId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(sessionId).append(pageId).toHashCode();
	}
	
}