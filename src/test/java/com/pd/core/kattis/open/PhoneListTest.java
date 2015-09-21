package com.pd.core.kattis.open;

import static org.junit.Assert.assertNotNull;

import java.io.*;

import org.junit.Test;

public class PhoneListTest {

	PhoneList objectUnderTest = new PhoneList();

	@Test
	public void testSetALL() throws IOException, InterruptedException {
		System.out.println("testSetALL");
		final FileInputStream fis = new FileInputStream("src/test/java/com/pd/core/kattis/open/test_rulesALL.txt");
		assertNotNull("Could not open rules", fis);

		objectUnderTest.readAndProcess(new InputStreamReader(fis));
		System.out.println("");

	}

	@Test
	public void testSet1() throws IOException, InterruptedException {
		System.out.println("testSet1");
		final FileInputStream fis = new FileInputStream("src/test/java/com/pd/core/kattis/open/test_rules1.txt");
		assertNotNull("Could not open rules", fis);

		objectUnderTest.readAndProcess(new InputStreamReader(fis));
		System.out.println("");

	}

	@Test
	public void testSet2() throws IOException, InterruptedException {
		System.out.println("testSet2");
		final FileInputStream fis = new FileInputStream("src/test/java/com/pd/core/kattis/open/test_rules2.txt");
		assertNotNull("Could not open rules", fis);

		objectUnderTest.readAndProcess(new InputStreamReader(fis));
		System.out.println("");

	}

	@Test
	public void testSet3() throws IOException, InterruptedException {
		System.out.println("testSet3");
		final FileInputStream fis = new FileInputStream("src/test/java/com/pd/core/kattis/open/test_rules3.txt");
		assertNotNull("Could not open rules", fis);

		objectUnderTest.readAndProcess(new InputStreamReader(fis));
		System.out.println("");

	}

	@Test
	public void testSet4() throws IOException, InterruptedException {
		System.out.println("testSet4");
		final FileInputStream fis = new FileInputStream("src/test/java/com/pd/core/kattis/open/test_rules4.txt");
		assertNotNull("Could not open rules", fis);

		objectUnderTest.readAndProcess(new InputStreamReader(fis));
		System.out.println("");

	}

	@Test
	public void testSet5() throws IOException, InterruptedException {
		System.out.println("testSet5");
		final FileInputStream fis = new FileInputStream("src/test/java/com/pd/core/kattis/open/test_rules5.txt");
		assertNotNull("Could not open rules", fis);

		objectUnderTest.readAndProcess(new InputStreamReader(fis));
		System.out.println("");

	}

	@Test
	public void testSet6() throws IOException, InterruptedException {
		System.out.println("testSet6");
		final FileInputStream fis = new FileInputStream("src/test/java/com/pd/core/kattis/open/test_rules6.txt");
		assertNotNull("Could not open rules", fis);

		objectUnderTest.readAndProcess(new InputStreamReader(fis));
		System.out.println("");

	}

	@Test
	public void testSet7() throws IOException, InterruptedException {
		System.out.println("testSet7");
		final FileInputStream fis = new FileInputStream("src/test/java/com/pd/core/kattis/open/test_rules7.txt");
		assertNotNull("Could not open rules", fis);

		objectUnderTest.readAndProcess(new InputStreamReader(fis));
		System.out.println("");

	}

	@Test
	public void testSet8() throws IOException, InterruptedException {
		System.out.println("testSet8");
		final FileInputStream fis = new FileInputStream("src/test/java/com/pd/core/kattis/open/test_rules8.txt");
		assertNotNull("Could not open rules", fis);

		objectUnderTest.readAndProcess(new InputStreamReader(fis));
		System.out.println("");

	}

}
