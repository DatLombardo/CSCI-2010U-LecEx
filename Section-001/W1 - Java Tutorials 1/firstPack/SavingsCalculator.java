package firstPack;

public class SavingsCalculator {
    public static void main(String[] args){
        double princ = 1000.0;
        float princ2 = 1000.0f;
        double interestRate = 0.035;
        int numYears = 10;
        //princ = princ + (princ * interestRate)
        for (int year = 0; year < numYears; year++){
            princ += interestRate * princ;
        }

        System.out.println("Interest Rate: " + interestRate + "\nPrincipal: " + princ);

        princ = 0.0;
        numYears = 0;
        double annunalContrib = 5000.0;

        while (princ < 1000000.0){
            princ += interestRate * princ + annunalContrib;
            numYears++;
        }
        System.out.printf("It will take you %d years to save ONE MILLION DOLLARS!", numYears);
    }
}
