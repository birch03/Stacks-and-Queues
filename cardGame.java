// Name: Quinn Stone
// Class: CSCI 145
// Teacher: Proffessor Darrell Criss
// Assignment: Lab1 Guessing Game
// User will guess a number and the program will record how many attempts it takes them to get it right

import java.util.Scanner;
import java.util.Stack;
import java.util.Collections;
import java.util.Random;

public class cardGame {

   static Stack<Integer> createStack(){
      Stack<Integer> deck = new Stack<Integer>();
      
      for (int i = 0; i < 4; i++) {
    	  deck.push(14);
    	  deck.push(2);
    	  deck.push(3);
    	  deck.push(4);
    	  deck.push(5);
    	  deck.push(6);
    	  deck.push(7);
    	  deck.push(8);
    	  deck.push(9);
    	  deck.push(10);
    	  deck.push(11);
    	  deck.push(12);
    	  deck.push(13);
      }
      
      //Shuffle Deck
      Collections.shuffle(deck);
      return deck;
   }
   
   static void turn() {
	   
   }
   
   static void startGame() {
	   System.out.println("Welcome to War");
	   System.out.println("In this programs card deck, an 'Ace' is 14, 'King' is 13, 'Queen' is 12, and 'Jack' is 11.");
	   System.out.println("In this game, both players play a card, whoever plays the higher card wins and takes both cards. If");
	   System.out.println("the two players play the same card, they will place 3 more down and then a fourth to decide the winner");
   }
   
   static int turn(Stack<Integer> player1, Stack<Integer> player2) {
	   //System.out.println(player1);
	   //System.out.println(player2);
	   
	   //Get top card of both decks
	   int player1Card = player1.peek();
	   int player2Card = player2.peek();
	   

	   
	   
	   System.out.printf("\nPlayer One card: " + player1Card + ", Cards left: "+player1.size());
	   System.out.printf("\nPlayer Two card: " + player2Card + ", Cards left: "+player2.size()+"\n");
	   
	   //Testing for What will happen when they are the same
	   //player1Card = 1;
	   //player2Card = 1;
	   
	   
	   if (player1Card > player2Card) {

		   return 1;
	   }
	   
	   else if (player1Card < player2Card) {

		   return 2;
	   }
	   
	   //What if the cards are the same?
	   else {
		   if (player1.size() <= 5) {
			   System.out.println("Game over! Player Two Wins!");
			   System.exit(0);
			   return 0;
		   }
		   
		   else if (player2.size() <= 5) {
			   System.out.println("Game over! Player One Wins!");
			   System.exit(0);
			   return 0;
		   }
		   
		   else {
			   return 3;
		   }

	   }
	   
	   
   }
   
   
   static void same(Stack<Integer> player1, Stack<Integer> player2, Stack<Integer> pot) {
	   
	   for (int j = 0; j < 4; j++) {
		   pot.push(player1.peek());
		   player1.pop();
		   pot.push(player2.peek());
		   player2.pop();
	   }

	   
	   if (player1.peek() > player2.peek()) {
		   player1.push(player2.peek());
		   player2.pop();
		   int size = pot.size();
		   for (int i = 0; i < size; i++) {
			   player1.push(pot.peek());
			   pot.pop();
		   }
		   
		 //put card in back of stack
		   int tempInt1 = player1.peek();
		   player1.pop();
	
		   Stack<Integer> temp1 = new Stack<Integer>();
		   while (!player1.empty()) {
			   temp1.push(player1.peek());
			   player1.pop();
		   }
		   player1.push(tempInt1);
		   
		   while (!temp1.empty()) {
			   player1.push(temp1.peek());
			   temp1.pop();
		   }

	   }
	   
	   else if (player2.peek() > player1.peek()) {
		   player2.push(player1.peek());
		   player1.pop();
		   int size = pot.size();
		   for (int i = 0; i < size; i++) {
			   player2.push(pot.peek());
			   pot.pop();
		   }
		 //put card in back of stack
		   int tempInt2 = player2.peek();
		   player2.pop();
	
		   Stack<Integer> temp2 = new Stack<Integer>();
		   while (!player2.empty()) {
			   temp2.push(player2.peek());
			   player2.pop();
		   }
		   player2.push(tempInt2);
		   
		   while (!temp2.empty()) {
			   player2.push(temp2.peek());
			   temp2.pop();
		   }

		   
	   }
	   
   }
   
   
   
   
   public static void main(String[] args) {


      //Create stack for Deck and for both players hands
      Stack<Integer> deck = createStack();
      Stack<Integer> player1 = new Stack<Integer>();
      Stack<Integer> player2 = new Stack<Integer>();
      
      //split deck into player1 hand and player2 hand
      while (deck.size() > 0) {
		  player1.push(deck.peek());
		  deck.pop();
		  player2.push(deck.peek());
		  deck.pop();
      }
      
      startGame();

      while (true) {
    	
    	  //System.out.println(player2);
	      if (player1.size() <= 0) {
	    	  System.out.println("Game over! Player Two Wins!");
	    	  System.exit(0);
	      }
	      
	      else if (player2.size() <= 0) {
	    	  System.out.println("Game over! Player One Wins!");
	    	  System.exit(0);
	      }
	      
	      
	      
	      
	      //////////////////////////////////////////////////////////
    	  //Confused on why I had to put this here but it didn't work right without it
    	  //////////////////////////////////////////////////////////
		   int tempInt3 = player1.peek();
		   player1.pop();
	
		   Stack<Integer> temp1 = new Stack<Integer>();
		   while (!player1.empty()) {
			   temp1.push(player1.peek());
			   player1.pop();
		   }
		   player1.push(tempInt3);
		   
		   while (!temp1.empty()) {
			   player1.push(temp1.peek());
			   temp1.pop();
		   }
		   
		   
		 //put card in back of stack
		   int tempInt4 = player2.peek();
		   player2.pop();
	
		   Stack<Integer> temp4 = new Stack<Integer>();
		   while (!player2.empty()) {
			   temp4.push(player2.peek());
			   player2.pop();
		   }
		   player2.push(tempInt4);
		   
		   while (!temp4.empty()) {
			   player2.push(temp4.peek());
			   temp4.pop();
		   }
		   
		   
		 
		   /////////////////////////////////////////////////////////
		   //Back to Program
		   
		   
    	  int winner = turn(player1, player2);
	      Stack<Integer> pot = new Stack<Integer>();

	      

	      
	      
		   if (winner == 1) {
			   player1.push(player2.peek());
			   player2.pop();

			   
			   //put card in back of stack
			   int tempInt1 = player1.peek();
			   player1.pop();
		
			   Stack<Integer> temp111 = new Stack<Integer>();
			   while (!player1.empty()) {
				   temp111.push(player1.peek());
				   player1.pop();
			   }
			   player1.push(tempInt1);
			   
			   while (!temp111.empty()) {
				   player1.push(temp111.peek());
				   temp111.pop();
			   }
			   
			   
		   }
		   
		   else if (winner == 2) {
			   player2.push(player1.peek());
			   player1.pop();

			   
			   
			   //put card in back of stack
			   int tempInt2 = player2.peek();
			   player2.pop();
		
			   Stack<Integer> temp2 = new Stack<Integer>();
			   while (!player2.empty()) {
				   temp2.push(player2.peek());
				   player2.pop();
			   }
			   player2.push(tempInt2);
			   
			   while (!temp2.empty()) {
				   player2.push(temp2.peek());
				   temp2.pop();
			   }
			   
			   
		   }
		   
		   //What if the cards are the same?
		   else {
			   same(player1, player2, pot);
	      }
     }
	   
   }
}