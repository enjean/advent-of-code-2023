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
}
