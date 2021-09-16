package java2.series;

// 1, 2, 4, 8, 16, ...
public class GeometricSeriesGenerator extends SeriesGenerator {

    public GeometricSeriesGenerator(double termFactor, double startValue) {

    }


    public static void main(String[] args) {
        GeometricSeriesGenerator gen = new GeometricSeriesGenerator(2.0, 1.0);

    }
}
