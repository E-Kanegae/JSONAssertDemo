package com.example.ek;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * JUnitJsonAssert
 * com.example.ek.ExampleTest.java
 *
 * JSONAssertライブラリの動作確認
 *
 * @author etsukanegae
 *
 */
public class JSONAsserTest {

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
		JSONAssert.assertEquals(expected, actual, false);
	}

	/**
	 *
	 * birdとcatが異なる。strictモード
	 *
	 * @throws JSONException
	 */
	@Test
	public void memberValueDiffrenceStrictTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joes\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		JSONAssert.assertEquals(expected, actual, true);
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
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		String actual = "{id:1,friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		JSONAssert.assertEquals(expected, actual, false);
	}

	/**
	 *
	 * name filedがないパターン。strictモード
	 *
	 *
	 * @throws JSONException
	 */
	@Test
	public void fieldsCountDiffrenceStrictTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		String actual = "{id:1,friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		JSONAssert.assertEquals(expected, actual, true);
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
		JSONAssert.assertEquals(expected, actual, false);
	}

	/**
	 *
	 * arrayの要素数が異なるパターン。strictモード
	 *
	 *
	 * @throws JSONException
	 */
	@Test
	public void arraySizeDiffrenceStrictTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		JSONAssert.assertEquals(expected, actual, true);
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
		JSONAssert.assertEquals(expected, actual, false);
	}

	/**
	 *
	 * 要素の順番が異なる。strictモード
	 *
	 * @throws JSONException
	 */
	@Test
	public void memberOrderDiffrenceStrictTest() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]},{id:2,name:\\\"Pat\\\",pets:[\\\"dog\\\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joes\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		JSONAssert.assertEquals(expected, actual, true);
	}

}
