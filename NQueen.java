/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueen;

import java.util.Date;

/**
 *
 * @author mengjinglu
 * I got the idea from: www.cnblogs.com/newflydd/p/5091646.html
 * N Queens rule: queens cannot be on same row, same column, same diagonal, each row
 * can only contain one queen, when we put a queen on next row, we need to test vertical, horizontal,
 * two diagonal to see if it attack other queens, if every spot of this row attack other queens, we need
 * to go back to last row to make some changes.
 */
public class NQueen {
    
    private static final short N = 5;
    private static int count = 0;
    public static void main(String[] args) {
        Date begin = new Date();
        
        short[][] chess = new short[N][N];
        for(int i = 0; i<N;i++){
            for(int j = 0;j<N;j++){
                chess[i][j]=0;
            }
        }
        putAtRow(chess,0);
    Date end = new Date();
    } 
    private static void putAtRow(short[][] chess, int row){
       /**
        *if row equal to N, that means we successfully stored N queens on the chessboard, 
        * they don't attack each other
        * then we can print out the result
        */
        if(row==N){
            count++;//counting how many ways to store N queens
            System.out.println("#"+ count +":");
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N;j++){
                    System.out.print(chess[i][j]+" ");
                }
            
            System.out.println();
            }
        return;
        } 
    
    short[][] chessTemp = chess.clone();//create a copy of chess
    /**
     * try to put queen at every spot of every row, call the isSafe method every time to
     * see if queens attack each other
     */
       for(int i  = 0; i < N; i++){
        for(int j = 0; j < N; j++)
            chessTemp[row][j]=0;
        chessTemp[row][i]=1;
        
        if(isSafe(chessTemp, row, i)){
            putAtRow(chessTemp, row+1);
        }
       }
    
    
    }
    //to test if queens attack each other
    public static boolean isSafe(short[][] chess, int row, int col){
       
        int step = 1;
        while(row-step>=0){
            if(chess[row-step][col]==1)
                return false;
            if(col-step>=0 && chess[row-step][col-step]==1)
                return false;
            if(col+step<N && chess[row-step][col+step]==1)
                return false;
            step++;
            
        }
        return true;
    }
    
    

}
