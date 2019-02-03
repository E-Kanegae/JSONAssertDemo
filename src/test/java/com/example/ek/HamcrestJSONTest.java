package com.example.ek;

import static org.junit.Assert.*;
import static uk.co.datumedge.hamcrest.json.SameJSONAs.*;

import org.json.JSONException;
import org.junit.Test;

/**
 * JUnitJsonAssert
 * com.example.ek.HamcrestJSONTest.java
 *
 * hamcrest-assertの動作確認
 *
 * @author etsukanegae
 *
 */
public class HamcrestJSONTest {

	/**
	 *
	 * birdとcatが異なる。
	 *
	 * @throws JSONException
	 */
	@Test
	public void memberValueDiffrenceTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joes\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		assertThat(
				actual,
				sameJSONAs(expected));
	}

	/**
	 *
	 * birdとcatが異なる。allowingExtraUnexpectedFieldsメソッドをつけた場合。
	 *
	 * @throws JSONException
	 */
	@Test
	public void memberValueDiffrenceAllowingExtraFieldsTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joes\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		assertThat(
				actual,
				sameJSONAs(expected).allowingExtraUnexpectedFields());
	}

	/**
	 *
	 * birdとcatが異なる。allowingAnyArrayOrderingメソッドをつけた場合。
	 *
	 * @throws JSONException
	 */
	@Test
	public void memberValueDiffrenceAllowingOrderTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joes\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		assertThat(
				actual,
				sameJSONAs(expected).allowingAnyArrayOrdering());
	}

	/**
	 *
	 * name filedがないパターン。
	 *
	 *
	 * @throws JSONException
	 */
	@Test
	public void fieldsCountDiffrenceTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
		String actual = "{id:1,friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		assertThat(
				actual,
				sameJSONAs(expected));
	}

	/**
	 *
	 * name filedがないパターン。allowingExtraUnexpectedFieldsメソッドをつけた場合。
	 *
	 *
	 * @throws JSONException
	 */
	@Test
	public void fieldsCountDiffrenceAllowingExtraFieldsTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
		String actual = "{id:1,friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		assertThat(
				actual,
				sameJSONAs(expected).allowingExtraUnexpectedFields());
	}

	/**
	 *
	 * name filedがないパターン。allowingAnyArrayOrderingメソッドをつけた場合。
	 *
	 * @throws JSONException
	 */
	@Test
	public void fieldsCountDiffrenceAllowingOrderTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
		String actual = "{id:1,friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		assertThat(
				actual,
				sameJSONAs(expected).allowingAnyArrayOrdering());
	}

	/**
	 *
	 * arrayの要素数が異なるパターン。
	 *
	 *
	 * @throws JSONException
	 */
	@Test
	public void arraySizeDiffrenceTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		assertThat(
				actual,
				sameJSONAs(expected));
	}

	/**
	 *
	 * arrayの要素数が異なるパターン。allowingExtraUnexpectedFieldsメソッドをつけた場合。
	 *
	 *
	 * @throws JSONException
	 */
	@Test
	public void arraySizeDiffrenceAllowingExtraFieldsTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		assertThat(
				actual,
				sameJSONAs(expected).allowingExtraUnexpectedFields());
	}


	/**
	 *
	 * 要素の順番が異なる。
	 *
	 * @throws JSONException
	 */
	@Test
	public void memberOrderDiffrenceTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]},{id:2,name:\\\"Pat\\\",pets:[\\\"dog\\\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joes\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		assertThat(
				actual,
				sameJSONAs(expected));
	}

	/**
	 *
	 * 要素の順番が異なる。allowingExtraUnexpectedFieldsメソッドをつけた場合。
	 *
	 * @throws JSONException
	 */
	@Test
	public void memberOrderDiffrenceAllowingExtraFieldsTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]},{id:2,name:\\\"Pat\\\",pets:[\\\"dog\\\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joes\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		assertThat(
				actual,
				sameJSONAs(expected).allowingExtraUnexpectedFields());
	}

	/**
	 *
	 * 要素の順番が異なる。allowingAnyArrayOrderingメソッドをつけた場合。
	 *
	 * @throws JSONException
	 */
	@Test
	public void memberOrderDiffrenceAllowingOrderTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joes\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		assertThat(
				actual,
				sameJSONAs(expected).allowingAnyArrayOrdering());
	}

}
