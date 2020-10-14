// Starting code Copyright 2014 University of South Australia
// Written by Michael Marner <michael.marner@unisa.edu.au>
//
package inft3032.scene;

import inft3032.math.Vector3;

/**
 * A class for a camera in a ray-tracer program.
 * <p/>
 *
 * @author a.sobey
 */
public class Camera {

    protected float heightAngle;
    protected float aspectRatio;
    protected Vector3 position;
    protected Vector3 direction;
    protected Vector3 up;
    protected Vector3 right;

    /**
     * Default constructor.
     *  Creates camera located along z axis at z=20, pointing towards the origin, with the up
     *  vector in the direction of the y-axis, the half angle equal to 45 degrees, and an aspect
     *  ratio of 1.0.
     */
    public Camera() {
        heightAngle = 45;
        aspectRatio = 1.0f;
        position = new Vector3(0, 0, 20);
        direction =  new Vector3(0, 0, -1);
        up = new Vector3(0, 1, 0);
        right = up.cross(direction);
    }
    
    
    public Camera(Vector3 position, Vector3 viewDirection, Vector3 up, float aspectRatio, float heightAngle) {
    	this.heightAngle = heightAngle;
    	this.aspectRatio = aspectRatio;
    	this.position = position;
    	this.direction = viewDirection;
    	this.up = up;
        right = up.cross(direction);
    }
    
    public void perspectiveM( float yFovInDegrees, float aspect, float n, float f) {
    	float[] m = new float[16];
        final float angleInRadians = (float) (yFovInDegrees * Math.PI / 180.0);

        final float a = (float) (1.0 / Math.tan(angleInRadians / 2.0));

        int i = 0;

        m[i++] = a / aspect;
        m[i++] = 0f;
        m[i++] = 0f;
        m[i++] = 0f;

        m[i++] = 0f;
        m[i++] = a;
        m[i++] = 0f;
        m[i++] = 0f;

        m[i++] = 0f;
        m[i++] = 0f;
        m[i++] = -((f + n) / (f - n));
        m[i++] = -1f;

        m[i++] = 0f;
        m[i++] = 0f;
        m[i++] = -(2f * f * n) / (f - n);
        m[i++] = 0f;
    }
    
    public float getHeightAngle() {
        return heightAngle;
    }

    public float getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getDirection() {
        return direction;
    }

    public Vector3 getUp() {
        return up;
    }

    public Vector3 getRight() {
        return right;
    }

}
