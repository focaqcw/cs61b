/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
public class GuitarHero {
    private static final double CONCERT_A = 440.0;
    private static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    private static final double CONCERT_Q = CONCERT_A * Math.pow(2, -24.0 / 12.0);
    private static final double CONCERT_2 = CONCERT_A * Math.pow(2, -23.0 / 12.0);
    private static final double CONCERT_W = CONCERT_A * Math.pow(2, -22.0 / 12.0);
    private static final double CONCERT_E = CONCERT_A * Math.pow(2, -21.0 / 12.0);
    private static final double CONCERT_4 = CONCERT_A * Math.pow(2, -20.0 / 12.0);
    private static final double CONCERT_R = CONCERT_A * Math.pow(2, -19.0 / 12.0);

    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        synthesizer.GuitarString stringA = new synthesizer.GuitarString(CONCERT_A);
        synthesizer.GuitarString stringC = new synthesizer.GuitarString(CONCERT_C);
        synthesizer.GuitarString stringQ = new synthesizer.GuitarString(CONCERT_Q);
        synthesizer.GuitarString string2 = new synthesizer.GuitarString(CONCERT_2);
        synthesizer.GuitarString stringW = new synthesizer.GuitarString(CONCERT_W);
        synthesizer.GuitarString stringE = new synthesizer.GuitarString(CONCERT_E);
        synthesizer.GuitarString string4 = new synthesizer.GuitarString(CONCERT_4);
        synthesizer.GuitarString stringR = new synthesizer.GuitarString(CONCERT_R);

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'a') {
                    stringA.pluck();
                } else if (key == 'c') {
                    stringC.pluck();
                } else if (key == 'q') {
                    stringQ.pluck();
                } else if (key == '2') {
                    string2.pluck();
                } else if (key == 'w') {
                    stringW.pluck();
                } else if (key == 'e') {
                    stringE.pluck();
                } else if (key == '4') {
                    string4.pluck();
                } else if (key == 'r') {
                    stringR.pluck();
                }
            }

        /* compute the superposition of samples */
            double sample = stringA.sample() + stringC.sample() + stringQ.sample()
                    + string2.sample() + stringW.sample() + stringE.sample()
                    + string4.sample() + stringR.sample();

        /* play the sample on standard audio */
            StdAudio.play(sample);

        /* advance the simulation of each guitar string by one step */
            stringA.tic();
            stringC.tic();
            stringQ.tic();
            string2.tic();
            stringW.tic();
            stringE.tic();
            string4.tic();
            stringR.tic();
        }
    }
}

