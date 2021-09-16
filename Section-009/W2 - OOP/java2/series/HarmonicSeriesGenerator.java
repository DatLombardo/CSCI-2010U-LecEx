package java2.series;

// 1 + 1/2 + 1/3 + 1/4
// 2 + 2/4 + 2/6 + 2/8
// 1 - 1/2 + 1/3 - 1/4
public class HarmonicSeriesGenerator extends SeriesGenerator {


    public HarmonicSeriesGenerator(double denominatorIncrement,
                                   double numerator,
                                   double startDenominator,
                                   boolean alternating) {
    }


    // 1 - 1/2 + 1/3 - 1/4
    public static void main(String[] args) {
        HarmonicSeriesGenerator gen = new HarmonicSeriesGenerator(1.0, 1.0, 1.0, true);

    }
}
