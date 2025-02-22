/**
 * 
 */
package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * 
 */
@SuppressWarnings("unused")
class TestDemoJUnitTest {

	private TestDemo testDemo;

	static Stream<Arguments> argumentsForAddPositive() {
		// @formatter:off
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(-2, 4, 2, true),
				arguments(2, 0, 2, true)
			);
		// @formatter:on
	};

	static Stream<Arguments> argumentsForDivide() {
		// @formatter:off
		return Stream.of(
				arguments(4, 2, 2, false),
				arguments(-4, 2, -2, false),
				arguments(1, 0, 0, true)
			);
		// @formatter:on
	}

	/**
	 * Ensures a new TestDemo object is created before each test.
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

//	@DisplayName("Two Positive Numbers Are Added Correctly")
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(17, 3)).isEqualTo(20);
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForDivide")
	void assertThatTwoNumbersAreDividedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.divide(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.divide(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);

		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();

		assertThat(fiveSquared).isEqualTo(25);
	}
}
