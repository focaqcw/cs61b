public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	/** constructors */
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;

	}
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	/** */
	public double calcDistance(Planet p){

		// double dx2 = Math.pow(xxPos - p.xxPos,2);
		// double dy2 = Math.pow(yyPos - p.yyPos,2);
		double dx2 = (xxPos - p.xxPos) * (xxPos - p.xxPos);
		double dy2 =(yyPos - p.yyPos)*(yyPos - p.yyPos);
		return Math.sqrt(dx2 + dy2);


	}

	public static final double G = 6.67e-11;

	public double calcForceExertedBy(Planet p){
		double r = this.calcDistance(p);
		double F = G * this.mass * p.mass / (r*r);
		return F;

	}

	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos - this.xxPos;
		double r = this.calcDistance(p);
		double F = this.calcForceExertedBy(p);
		return F * dx / r;

	}

	public double calcForceExertedByY(Planet p){
		double dy = p.yyPos - this.yyPos;
		double r = this.calcDistance(p);
		double F = this.calcForceExertedBy(p);
		return F * dy / r;
	}

	public double calcNetForceExertedByX(Planet[] pp){
		double netforce = 0;
		 for (Planet p : pp){
		 	if( p == this){
		 		continue;
		 	}
		 	netforce += this.calcForceExertedByX(p);
		 }
		 return netforce;
	}

	public double calcNetForceExertedByY(Planet[] pp){
		double netforce = 0;
		 for (Planet p : pp){
		 	if( p == this){
		 		continue;
		 	}
		 	netforce += this.calcForceExertedByY(p);
		 }
		 return netforce;
		
	}

	public void update(double dt, double Fx, double Fy){
		double ax = Fx / this.mass;
		double ay = Fy / this.mass;
		this.xxVel = xxVel + dt * ax;
		this.yyVel = yyVel + dt * ay;
		this.xxPos = xxPos + xxVel * dt;
		this.yyPos = yyPos + yyVel * dt;


	}

	public void draw(){
		
		StdDraw.picture(xxPos, yyPos, imgFileName);
		// StdDraw.show();
		// StdDraw.pause(200000);

	}






}