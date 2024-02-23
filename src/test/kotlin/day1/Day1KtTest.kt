package day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class Day1KtTest {
    @ParameterizedTest
    @ArgumentsSource(CalibrationValueArgumentsProvider::class)
    fun `calculate calibration value`(
        line: String,
        expectedValue: Int,
    ) {
        assertEquals(expectedValue, getCalibrationValue(line))
    }

    private class CalibrationValueArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("1abc2", 12),
                Arguments.of("pqr3stu8vwx", 38),
                Arguments.of("a1b2c3d4e5f", 15),
                Arguments.of("treb7uchet", 77),
            )
        }
    }

    @ParameterizedTest
    @ArgumentsSource(UpdatedCalibrationValueArgumentsProvider::class)
    fun `calculate updated calibration value`(
        line: String,
        expectedValue: Int,
    ) {
        assertEquals(expectedValue, getUpdatedCalibrationValue(line))
    }

    private class UpdatedCalibrationValueArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<out Arguments> {
            return Stream.of(
                Arguments.of("two1nine", 29),
                Arguments.of("eightwothree", 83),
                Arguments.of("abcone2threexyz", 13),
                Arguments.of("xtwone3four", 24),
                Arguments.of("4nineeightseven2", 42),
                Arguments.of("zoneight234", 14),
                Arguments.of("7pqrstsixteen", 76),
                Arguments.of("9eightszgdhftggrktkzbsmnhtwonekh", 91),
            )
        }
    }
}
