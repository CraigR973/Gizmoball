package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.Test;

import model.Absorber;
import model.Ball;
import model.CircleGizmo;
import model.LeftFlipper;
import model.Model;
import model.PhysicsLoop;
import model.RightFlipper;
import model.SquareGizmo;
import model.TriangleGizmo;
import physics.Vect;

public class GizmosTest {

	Model model = new Model();
	PhysicsLoop pl = new PhysicsLoop(model.getBalls(), model.getWalls() , model.getAbs(), false, model.getSquares(), model.getCircles(),
			model.getTriangles(), model.getLFlipper(), model.getRFlipper());
	
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
		model.addTriangleGizmo(12, 12);
		model.addTriangleGizmo(15, 15);
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
	
	@Test
	public void deleteTri1() {
		model.addTriangleGizmo(10, 10);
		model.addTriangleGizmo(10, 11);
		assertEquals(model.getTriangles().size(),2);
		model.deleteGizmo(10, 11);
		assertEquals(model.getTriangles().size(),1);
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
		model.addSquareGizmo(12, 12);
		assertEquals(model.getSquares().size(),1);
	}
	
	@Test
	public void addSquareSize2() {
		assertEquals(model.getSquares().size(),0);
		model.addSquareGizmo(12, 12);
		model.addSquareGizmo(15, 15);
		assertEquals(model.getSquares().size(),2);
	}
	
	@Test
	public void deleteSquare() {
		model.addSquareGizmo(10, 10);
		assertEquals(model.getSquares().size(),1);
		model.deleteGizmo(10, 10);
		assertEquals(model.getSquares().size(),0);
	}
	
	@Test
	public void deleteSquare1() {
		model.addSquareGizmo(10, 10);
		model.addSquareGizmo(10, 11);
		assertEquals(model.getSquares().size(),2);
		model.deleteGizmo(10, 11);
		assertEquals(model.getSquares().size(),1);
	}
	
	//Checks to make sure square is placed in correct x and y points
	@Test
	public void checkSquarePlacement() {
		model.addSquareGizmo(12, 12);
		ArrayList<SquareGizmo> squares = model.getSquares();
		int x = (int) (squares.get(0).getXPos()/20);
		int y = (int) (squares.get(0).getYPos()/20);
		assertEquals(x,12);
		assertEquals(y,12);
	}
	
	//Checks to see if circle is added to array
	@Test
	public void addCirlceSize() {
		assertEquals(model.getCircles().size(),0);
		model.addCircleGizmo(3, 3);
		assertEquals(model.getCircles().size(),1);
	}
	
	@Test
	public void addCirlceSize2() {
		assertEquals(model.getCircles().size(),0);
		model.addCircleGizmo(3, 3);
		model.addCircleGizmo(3, 4);
		assertEquals(model.getCircles().size(),2);
	}
	
	@Test
	public void deleteCirc() {
		model.addCircleGizmo(3, 3);
		assertEquals(model.getCircles().size(),1);
		model.deleteGizmo(3, 3);
		assertEquals(model.getCircles().size(),0);
	}
	
	@Test
	public void deleteCirc1() {
		model.addCircleGizmo(3, 3);
		model.addCircleGizmo(3, 4);
		assertEquals(model.getCircles().size(),2);
		model.deleteGizmo(3, 4);
		assertEquals(model.getCircles().size(),1);
	}
	
	//Checks to make sure circle is placed in correct x and y points
	@Test
	public void checkCirclePlacement() {
		model.addCircleGizmo(3, 3);
		ArrayList<CircleGizmo> circles = model.getCircles();
		int x = (int) (circles.get(0).getExactX()/20);
		int y = (int) (circles.get(0).getExactY()/20);
		assertEquals(x,3);
		assertEquals(y,3);
	}
	
	//Checks to see if ball is added to array
	@Test
	public void addBallSize() {
		assertEquals(model.getBalls().size(),0);
		model.addBallGizmo(10, 10, 0, 0);
		assertEquals(model.getBalls().size(),1);
	}
	
	@Test
	public void deleteBall() {
		model.addBallGizmo(14, 14, 0, 0);
		assertEquals(model.getBalls().size(),1);
		model.deleteGizmo(14, 14);
		assertEquals(model.getBalls().size(),0);
	}
	
	@Test
	public void deleteBall1() {
		model.addBallGizmo(14, 14, 0, 0);
		model.addBallGizmo(14, 15, 0, 0);
		assertEquals(model.getBalls().size(),1);
		model.deleteGizmo(14, 15);
		assertEquals(model.getBalls().size(),1);
	}
	
	//Checks to make sure ball is placed in correct x and y points
	@Test
	public void checkBallPlacement() {
		model.addBallGizmo(4, 4, 0, 0);
		ArrayList<Ball> balls = model.getBalls();
		int x = (int) (balls.get(0).getExactX()/20);
		int y = (int) (balls.get(0).getExactY()/20);
		assertEquals(x,4);
		assertEquals(y,4);
	}
	
//	//Checks to see if absorber is added to array
	@Test
	public void addAbsorberSize() {
		assertEquals(model.getAbs().size(),0);
		model.addAbsorberGizmo(0, 16, 2, 2);
		assertEquals(model.getAbs().size(),1);
	}
	
	@Test
	public void deleteAbs() {
		model.addAbsorberGizmo(0, 16, 2, 2);
		assertEquals(model.getAbs().size(),1);
		model.deleteGizmo(0,16);
		assertEquals(model.getAbs().size(),0);
	}
	
	@Test
	public void deleteAbs1() {
		model.addAbsorberGizmo(0, 16, 2, 2);
		model.addAbsorberGizmo(14, 19 , 2, 2);
		assertEquals(model.getAbs().size(),2);
		model.deleteGizmo(1,16);
		assertEquals(model.getAbs().size(),2);
	}
	
	//Checks to make sure absorber is placed in correct x and y points
	@Test
	public void checkAbsorberPlacement() {
		model.addAbsorberGizmo(0, 16, 2, 2);
		ArrayList<Absorber> abs = model.getAbs();
		int x = (int) (abs.get(0).getXPos()/20);
		assertEquals(x,0);
	}
	
	//Checks to see if left flipper is added to array
	@Test
	public void addLeftFlipperSize() {
		assertEquals(model.getLFlipper().size(),0);
		model.addLFlipperGizmo(15, 15);
		assertEquals(model.getLFlipper().size(),1);
	}
	
	@Test
	public void deleteLeftFlipper() {
		model.addLFlipperGizmo(15,15);
		assertEquals(model.getLFlipper().size(),1);
		model.deleteGizmo(15,15);
		assertEquals(model.getLFlipper().size(),0);
	}
	
	//Checks to make sure left flipper is placed in correct x and y points
	@Test
	public void checkLeftFlipperPlacement() {
		model.addLFlipperGizmo(15, 15);
		ArrayList<LeftFlipper> lf = model.getLFlipper();
		int x = (int) (lf.get(0).getXPos()/20);
		int y = (int) (lf.get(0).getYPos()/20);
		assertEquals(x,15);
		assertEquals(y,15);
	}
	
	//Checks to see if right flipper is added to array
	@Test
	public void addRightFlipperrSize() {
		assertEquals(model.getRFlipper().size(),0);
		model.addRFlipperGizmo(6, 6);
		assertEquals(model.getRFlipper().size(),1);
	}
	
	@Test
	public void deleteRightFlipper() {
		model.addRFlipperGizmo(15,15);
		assertEquals(model.getRFlipper().size(),1);
		model.deleteGizmo(15,15);
		assertEquals(model.getRFlipper().size(),0);
	}
	
	//Checks to make sure right flipper is placed in correct x and y points
	@Test
	public void checkRightFlipperPlacement() {
		model.addRFlipperGizmo(7, 7);
		ArrayList<RightFlipper> rf = model.getRFlipper();
		int x = (int) (rf.get(0).getXPos()/20);
		int y = (int) (rf.get(0).getYPos()/20);
		assertEquals(x,7);
		assertEquals(y,7);
	}
	
	//Only works when user enters name of file
	@Test
	public void checkLoadingFile() {
		assertEquals(model.getSquares().size(),0);
		model.load();
		assertEquals(model.getSquares().size(),16);
	}
	
	//Checks to see if triangle rotations are stored successfully 
	@Test
	public void checkTriangleRotation() {
		model.addTriangleGizmo(10, 10);
		assertEquals(model.getTriangles().size(),1);
		model.getTriangles().get(0).addRotation();
		assertEquals(model.getTriangles().get(0).getNoRotations(), 1);
	}
	
	//Test for checking two squares placed at same coordinates
	@Test
	public void add2Squares() {
		assertEquals(model.getSquares().size(),0);
		model.addSquareGizmo(7, 7);
		assertEquals(model.getSquares().size(),1);
		model.addSquareGizmo(7, 7);
		assertEquals(model.getSquares().size(),1);
	}
	
	//Test for two different gizmos placed at same coordinates
	@Test
	public void add2Gizmos() {
		assertEquals(model.getSquares().size(),0);
		model.addSquareGizmo(7, 7);
		assertEquals(model.getSquares().size(),1);
		model.addTriangleGizmo(7, 7);
		assertEquals(model.getSquares().size(),1);
		assertEquals(model.getTriangles().size(),0);
	}
	
	
	//Checks to see if left flipper changes colour
	@Test
	public void changeLFColour()
	{
		model.addLFlipperGizmo(5, 5);
		Color c1 = model.getLFlipper().get(0).getColour();
		model.getLFlipper().get(0).setColour();
		Color c2 = model.getLFlipper().get(0).getColour();
		assertNotEquals(c1, c2);
	}
	
	//checks to see if flipper changes back to original colour
	@Test
	public void changeLFColour2()
	{
		model.addLFlipperGizmo(5, 5);
		Color c1 = model.getLFlipper().get(0).getColour();
		model.getLFlipper().get(0).setColour1();
		Color c2 = model.getLFlipper().get(0).getColour();
		assertNotEquals(c1, c2);
	}
	
	
	@Test
	public void changeLFVelo()
	{
		model.addLFlipperGizmo(5, 5);
		Vect v1 = model.getLFlipper().get(0).getVelo();
		model.getLFlipper().get(0).setVelo(new Vect(10, 10));
		Vect v2 = model.getLFlipper().get(0).getVelo();
		assertNotEquals(v1, v2);
	}
	
	//test to add gizmos to board then clear them
	@Test
	public void testClear()
	{
		model.addLFlipperGizmo(15, 15);
		model.addRFlipperGizmo(6, 6);
		model.addSquareGizmo(4, 4);
		model.addSquareGizmo(17, 18);
		model.addTriangleGizmo(10, 10);
		model.addCircleGizmo(11, 11);
		//model.addAbsorberGizmo(19);
		model.addBallGizmo(10, 10, 0, 0);
		model.clearBoard();
		
		assertEquals(model.getTriangles().size(),0);
		assertEquals(model.getCircles().size(),0);
		assertEquals(model.getSquares().size(),0);
		assertEquals(model.getLFlipper().size(),0);
		assertEquals(model.getRFlipper().size(),0);
		//assertEquals(model.getAbs().size(),0);
		assertEquals(model.getBalls().size(),0);
	}
	
	//test for clearing an empty board
	@Test
	public void testClearEmptyBoard()
	{
		model.clearBoard();
		
		assertEquals(model.getTriangles().size(),0);
		assertEquals(model.getCircles().size(),0);
		assertEquals(model.getSquares().size(),0);
		assertEquals(model.getLFlipper().size(),0);
		assertEquals(model.getRFlipper().size(),0);
		assertEquals(model.getAbs().size(),0);
		assertEquals(model.getBalls().size(),0);
	}
	
	//test for loading in a board then clearing it
	@Test
	public void testClearLoadedBoard()
	{
		model.load();
		
		model.clearBoard();
		
		assertEquals(model.getTriangles().size(),0);
		assertEquals(model.getCircles().size(),0);
		assertEquals(model.getSquares().size(),0);
		assertEquals(model.getLFlipper().size(),0);
		assertEquals(model.getRFlipper().size(),0);
		assertEquals(model.getAbs().size(),0);
		assertEquals(model.getBalls().size(),0);
	}
	
	//testing for multiple balls being added
	@Test
	public void testMultipleBalls(){
		model.addBallGizmo(10, 10, 0, 0);
		model.addBallGizmo(11, 11, 0, 0);
		
		assertEquals(model.getBalls().size(),1);
	}
	
	//test for adding an absorber over another gizmo
	@Test
	public void testCantAddAbsorber(){
		
		model.addSquareGizmo(0, 19);
	//	model.addAbsorberGizmo(19);
		
		assertEquals(model.getAbs().size(),0);
	}
	
	//test for adding a right flipper over another gizmo
	@Test
	public void testCantAddRightFlipper(){
		
		model.addSquareGizmo(10, 19);
		model.addRFlipperGizmo(10, 19);
		
		assertEquals(model.getRFlipper().size(),0);
	}
	
	//test for adding a left flipper over another gizmo
	@Test
	public void testCantAddLeftFlipper(){
		
		model.addSquareGizmo(10, 19);
		model.addLFlipperGizmo(10, 19);
		
		assertEquals(model.getLFlipper().size(),0);
	}
	
	
	
	@Test
	public void testChangeSqColour(){
		
		model.addSquareGizmo(10, 19);
		model.getSquares().get(0).setColour(Color.WHITE);
		
		assertEquals(model.getSquares().get(0).getColour(), Color.WHITE);
	}
	
	@Test
	public void testGetGizmo(){
		
		model.addSquareGizmo(10, 19);
		model.addCircleGizmo(2, 4);
		model.addTriangleGizmo(5, 8);
		model.addLFlipperGizmo(9, 9);
		model.addRFlipperGizmo(18, 18);
		model.addAbsorberGizmo(1, 1, 1,1);
		assertEquals(model.getGizmo(10, 19), "S1019");
		assertEquals(model.getGizmo(2, 4), "C24");
		assertEquals(model.getGizmo(5, 8), "T58");
		assertEquals(model.getGizmo(9, 9), "LF99");
		assertEquals(model.getGizmo(18, 18), "RF1818");
		assertEquals(model.getGizmo(1, 1), "A11");
	}
	
	
	
	
	
	
}