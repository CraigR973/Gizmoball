package controller;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;

import javax.swing.event.MouseInputListener;

public interface GizmoBallListener extends ActionListener, WindowListener, KeyListener, MouseInputListener {

	public void setMouseListener(MouseInputListener ml);

	public void setKeyBoardListener(KeyListener kl);
}