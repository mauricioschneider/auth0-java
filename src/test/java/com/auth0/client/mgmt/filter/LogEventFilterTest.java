package com.auth0.client.mgmt.filter;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class LogEventFilterTest {

    private LogEventFilter filter;

    @Before
    public void setUp() throws Exception {
        filter = new LogEventFilter();
    }

    @Test
    public void shouldFilterByCheckpoint() throws Exception {
        LogEventFilter instance = filter.withCheckpoint("log123", 10);

        assertThat(filter, is(instance));
        assertThat(filter.getAsMap(), is(notNullValue()));
        assertThat(filter.getAsMap(), Matchers.hasEntry("from", (Object) "log123"));
        assertThat(filter.getAsMap(), Matchers.hasEntry("take", (Object) 10));
    }

    @Test
    public void shouldIncludeTotals() throws Exception {
        LogEventFilter instance = filter.withTotals(true);

        assertThat(filter, is(instance));
        assertThat(filter.getAsMap(), is(notNullValue()));
        assertThat(filter.getAsMap(), Matchers.hasEntry("include_totals", (Object) true));
    }

    @Test
    public void shouldFilterByQuery() throws Exception {
        LogEventFilter instance = filter.withQuery("id=log123");

        assertThat(filter, is(instance));
        assertThat(filter.getAsMap(), is(notNullValue()));
        assertThat(filter.getAsMap(), Matchers.hasEntry("q", (Object) "id=log123"));
    }

    @Test
    public void shouldSort() throws Exception {
        LogEventFilter instance = filter.withSort("date:-1");

        assertThat(filter, is(instance));
        assertThat(filter.getAsMap(), is(notNullValue()));
        assertThat(filter.getAsMap(), Matchers.hasEntry("sort", (Object) "date:-1"));
    }

    @Test
    public void shouldFilterByPage() throws Exception {
        LogEventFilter instance = filter.withPage(15, 50);

        assertThat(filter, is(instance));
        assertThat(filter.getAsMap(), is(notNullValue()));
        assertThat(filter.getAsMap(), Matchers.hasEntry("page", (Object) 15));
        assertThat(filter.getAsMap(), Matchers.hasEntry("per_page", (Object) 50));
    }

    @Test
    public void shouldFilterByWithFields() throws Exception {
        LogEventFilter instance = filter.withFields("a,b,c", true);

        assertThat(filter, is(instance));
        assertThat(filter.getAsMap(), is(notNullValue()));
        assertThat(filter.getAsMap(), Matchers.hasEntry("fields", (Object) "a,b,c"));
        assertThat(filter.getAsMap(), Matchers.hasEntry("include_fields", (Object) true));
    }

    @Test
    public void shouldFilterWithoutFields() throws Exception {
        LogEventFilter instance = filter.withFields("a,b,c", false);

        assertThat(filter, is(instance));
        assertThat(filter.getAsMap(), is(notNullValue()));
        assertThat(filter.getAsMap(), Matchers.hasEntry("fields", (Object) "a,b,c"));
        assertThat(filter.getAsMap(), Matchers.hasEntry("include_fields", (Object) false));
    }
}