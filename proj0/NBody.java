public class NBody{



	public static double readRadius(String dir){
		In in = new In(dir);
		int N = in.readInt();
		double R = in.readDouble();
		return R;
	}


	public static Planet[] readPlanets(String dir){
		In in = new In(dir);
		int N = in.readInt();
		double R = in.readDouble();

		Planet[] planets = new Planet[5];
		for(int i = 0; i < 5; i++){

			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();;
			String imgFileName = "images/"+in.readString();;
			Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
			planets[i] = p;
		}
		return planets;
	}




	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();

        double T = Double.valueOf(args[0]);
        double dt  = Double.valueOf(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);

        StdDraw.picture(0, 0, "images/starfield.jpg");


        planets[0].draw();
        planets[1].draw();
        planets[2].draw();
        planets[3].draw();
        planets[4].draw();

        StdDraw.show();

        for(double init_t = 0; init_t < T; init_t = init_t+dt){

        	double[] xForces = new double[5];
	        double[] yForces = new double[5];
	        StdDraw.picture(0, 0, "images/starfield.jpg");
	        // StdDraw.clear();
        	for(int i = 0; i < 5; i++){

	        	xForces[i] = planets[i].calcNetForceExertedByX(planets);
	        	yForces[i] = planets[i].calcNetForceExertedByY(planets);
	        	// planets[i].update(dt,xForces[i], yForces[i]);
	        	// planets[i].draw();
	        	// System.out.println(i)

        	}
        	for(int i = 0; i < 5; i++){

	        	// xForces[i] = planets[i].calcNetForceExertedByX(planets);
	        	// yForces[i] = planets[i].calcNetForceExertedByY(planets);
	        	planets[i].update(dt,xForces[i], yForces[i]);
	        	planets[i].draw();
	        	System.out.println(i);

        	}
        	// StdDraw.clear();
        	StdDraw.show();
        	StdDraw.pause(10);


        }






    }


}