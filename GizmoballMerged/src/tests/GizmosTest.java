package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Absorber;
import model.Ball;
import model.CircleGizmo;
import model.LeftFlipper;
import model.Model;
import model.RightFlipper;
import model.SquareGizmo;
import model.TriangleGizmo;

public class GizmosTest {

	Model model = new Model();
	
	//Checks to see if triangle is added to array
	@Test
	public void addTriSize() {
		assertEquals(model.getTriangles().size(),0);
		model.addTriangleGizmo(10, 10);
		assertEquals(model.getTriangles().size(),1);
	}
	
	//Checks to make sure 3 triangles are added correctly
	@Test
	public void addTriSize2() {
		assertEquals(model.getTriangles().size(),0);
		model.addTriangleGizmo(10, 10);
		model.addTriangleGizmo(20, 20);
		model.addTriangleGizmo(30, 30);
		assertEquals(model.getTriangles().size(),3);
	}
	
	//Checks to make sure triangle is successfully deleted
	@Test
	public void deleteTri() {
		model.addTriangleGizmo(10, 10);
		assertEquals(model.getTriangles().size(),1);
		model.deleteGizmo(10, 10);
		assertEquals(model.getTriangles().size(),0);
	}
	
	//Checks to make sure triangle is placed in correct x and y points
	@Test
	public void checkTriPlacement() {
		model.addTriangleGizmo(10, 10);
		ArrayList<TriangleGizmo> tris = model.getTriangles();
		int x = (int) (tris.get(0).getXpos1()/20);
		int y = (int) (tris.get(0).getYpos1()/20);
		assertEquals(x,10);
		assertEquals(y,10);
	}
	
	//Checks to see if square is added to array
	@Test
	public void addSquareSize() {
		assertEquals(model.getSquares().size(),0);
		model.addSquareGizmo(20, 20);
		assertEquals(model.getSquares().size(),1);
	}
	
	//Checks to make sure square is placed in correct x and y points
	@Test
	public void checkSquarePlacement() {
		model.addSquareGizmo(20, 20);
		ArrayList<SquareGizmo> squares = model.getSquares();
		int x = (int) (squares.get(0).getXPos()/20);
		int y = (int) (squares.get(0).getYPos()/20);
		assertEquals(x,20);
		assertEquals(y,20);
	}
	
	//Checks to see if circle is added to array
	@Test
	public void addCirlceSize() {
		assertEquals(model.getCircles().size(),0);
		model.addCircleGizmo(30, 30);
		assertEquals(model.getCircles().size(),1);
	}
	
	//Checks to make sure circle is placed in correct x and y points
	@Test
	public void checkCirlcePlacement() {
		model.addCircleGizmo(30, 30);
		ArrayList<CircleGizmo> circles = model.getCircles();
		int x = (int) (circles.get(0).getExactX()/20);
		int y = (int) (circles.get(0).getExactY()/20);
		assertEquals(x,30);
		assertEquals(y,30);
	}
	
	//Checks to see if ball is added to array
	@Test
	public void addBallSize() {
		assertEquals(model.getBalls().size(),0);
		model.addBallGizmo(40, 40);
		assertEquals(model.getBalls().size(),1);
	}
	
	//Checks to make sure ball is placed in correct x and y points
	@Test
	public void checkBallPlacement() {
		model.addBallGizmo(40, 40);
		ArrayList<Ball> balls = model.getBalls();
		int x = (int) (balls.get(0).getExactX()/20);
		int y = (int) (balls.get(0).getExactY()/20);
		assertEquals(x,40);
		assertEquals(y,40);
	}
	
	//Checks to see if absorber is added to array
	@Test
	public void addAbsorberSize() {
		assertEquals(model.getAbs().size(),0);
		model.addAbsorberGizmo(0);
		assertEquals(model.getAbs().size(),1);
	}
	
	//Checks to make sure absorber is placed in correct x and y points
	@Test
	public void checkAbsorberPlacement() {
		model.addAbsorberGizmo(0);
		ArrayList<Absorber> abs = model.getAbs();
		int x = (int) (abs.get(0).getXPos()/20);
		assertEquals(x,0);
	}
	
	//Checks to see if left flipper is added to array
	@Test
	public void addLeftFlipperSize() {
		assertEquals(model.getLFlipper().size(),0);
		model.addLFlipperGizmo(50, 50);
		assertEquals(model.getLFlipper().size(),1);
	}
	
	//Checks to make sure left flipper is placed in correct x and y points
	@Test
	public void checkLeftFlipperPlacement() {
		model.addLFlipperGizmo(50, 50);
		ArrayList<LeftFlipper> lf = model.getLFlipper();
		int x = (int) (lf.get(0).getXPos()/20);
		int y = (int) (lf.get(0).getYPos()/20);
		assertEquals(x,50);
		assertEquals(y,50);;
	}
	
	//Checks to see if right flipper is added to array
	@Test
	public void addRightFlipperrSize() {
		assertEquals(model.getRFlipper().size(),0);
		model.addRFlipperGizmo(60, 60);
		assertEquals(model.getRFlipper().size(),1);
	}
	
	//Checks to make sure right flipper is placed in correct x and y points
	@Test
	public void checkRightFlipperPlacement() {
		model.addRFlipperGizmo(60, 60);
		ArrayList<RightFlipper> rf = model.getRFlipper();
		int x = (int) (rf.get(0).getXPos()/20);
		int y = (int) (rf.get(0).getYPos()/20);
		assertEquals(x,60);
		assertEquals(y,60);
	}
	
	//Only works when user enters name of file
//	@Test
//	public void checkLoadingFile() {
//		assertEquals(model.getCircles().size(),0);
//		model.load();
//		assertEquals(model.getCircles().size(),13);
//	}
	
	//Checks to see if triangle rotations are stored successfully 
	@Test
	public void checkTriangleRotation() {
		model.addTriangleGizmo(10, 10);
		assertEquals(model.getTriangles().size(),1);
		model.getTriangles().get(0).addRotation();
		assertEquals(model.getTriangles().get(0).getNoRotations(), 1);
	}
}
