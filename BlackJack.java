package Game;
import java.util.*;
import java.lang.*;
import java.util.Random;
import java.util.Arrays;
class BlackJack{

 public static void main(String args[]){
   
   Scanner scan = new Scanner(System.in);


  System.out.println("Do you want to play black Jack enter 1 if Yes else press 2");
  int black_jack_play = scan.nextInt();
  if(black_jack_play == 2){
       System.exit(0);
  }else if(black_jack_play == 1){
     black_jack();
  }else{
   System.out.println("Invalid input enter 1 for yes 2 for no!!");
  }
  
  

 }
 
 static void black_jack(){
 Scanner scan = new Scanner(System.in);

  String[] cards ={"HA","H2","H3" , "H4" , "H5", "H6","H7", "H8", "H9", "H10",  "HQ","HK","DA", "D2", "D3" , "D4" , "D5", "D6","D7", "D8", "D9", "D10", "DQ", "DK","CA", "C2", "C3" , "C4" , "C5", "C6","C7", "C8", "C9", "C10", "CQ", "CK","SA", "S2", "S3" , "S4" , "S5", "S6","S7", "S8", "S9", "S10",  "SQ", "SK"};
  String[] copy_cards =  Arrays.copyOfRange(cards, 0, 52);
  String user[] = new String[52];
  String dealer[] = new String[52];
  String user_copy[] = new String[52];
  String dealer_copy[] = new String[52];

  int no_of_deals = 1;
  
  ///////////////////////////Giving Cards to Dealer/////////////////////////////////////////////////
  dealer = draw(1,cards,dealer);
  System.out.println("Providing initial card to dealer ");
  for(int i=0;i<dealer.length;i++){
     if(dealer[i]==null){ break;}
     System.out.print(dealer[i] + "  " );
  }
  System.out.println();
  cards = reduce_cards(cards,1,52);
  
  cards = shuffle(cards);
  int count_dealer =1;

  ///////////////////////////////////////////////////////////////////////////
  
   
  //////////////////////////////Giving Cards to user///////////////////////////////////////////////////
  
        
  user = draw(1,cards,user);
  System.out.println("Providing initial cards to user ");
  for(int i=0;i<user.length;i++){
     if(user[i]==null){ break;}
     System.out.print(user[i] + "  " );
  }
  System.out.println();
  
  cards = reduce_cards(cards,1,52);
  
  cards = shuffle(cards);
  /////////////////////////////////////////////////////////////////////////////////

  System.out.println("The shuffled cards are:");
  for(int i=0;i<cards.length;i++){
     if(cards[i]==null){ break;}
     System.out.print(cards[i] + "  " );
  }
  System.out.println(); 
  ////////////////////////////////////////////////////////////////////////////
  
  int choice=0;
  String new_user[] = new String[52];
  int user_count = 1;
   int dealer_sum =0,user_sum=0;

  while(true){
     System.out.print("Enter \n 1) If user wants to take a card/draw else enter \n 2) If user wants a new deal \n 3) Exit \n");
     choice = scan.nextInt();
     System.out.println();
     
     if(choice == 1){
         int no_of_cards=0;
         int new_user_count =0;
         no_of_cards = 1;
         int j =0;
         for(int i=user_count  ;i<user_count  + no_of_cards ;i++){
          user[i]= cards[j];
          j++;
         }
                  
        System.out.println("The cards given after hand pick for the user  are:");
        for(int i=0;i<user.length;i++){
          if(user[i]==null){ break;}
           System.out.print(user[i] + "  " );
        }
        System.out.println();
        user_count+=1;
       
       cards = reduce_cards(cards,no_of_cards,52);
       
       
       //Giving card to dealer
       int k =0;
        for(int i=count_dealer  ;i<count_dealer  + no_of_cards ;i++){
         dealer[i]= cards[k];
         k++;
        } 
        count_dealer+=1;
        
               
         System.out.println("Cards given to dealer are(2nd pick not shown therefor one card less than user is shown):");
        for(int i=0;i<dealer.length;i++){
          if(dealer[i]==null){ break;}
          if(i!=1){
            System.out.print(dealer[i] + "  " );
          }
        }
        System.out.println();

        
       cards = reduce_cards(cards,no_of_cards,52);
            
       if(count_dealer == 2){
         int dealer_try_win =0, user_try_win =0, d_A=0, d_K_Q = 0,u_A=0, u_K_Q = 0;
         
         //checking for dealer win
         for(int i=0;i<dealer.length;i++){
           if(dealer[i]==null){  break; }
          if(dealer[i].equals("HK") || dealer[i].equals("SK") || dealer[i].equals("DK") || dealer[i].equals("CK") || dealer[i].equals("HQ") || dealer[i].equals("SQ") || dealer[i].equals("DQ") || dealer[i].equals("CQ") )
           {
                         d_K_Q = 1;
           }  
           if(  dealer[i].equals("HA") || dealer[i].equals("SA") || dealer[i].equals("DA") || dealer[i].equals("CA") )
           {

                           d_A = 1;
           }
            if( u_K_Q == 1 && u_A ==1){ user_try_win =1; break;}

        } 
        
        //checking for user win
        for(int i=0;i<user.length;i++){
           if(user[i]==null){ break;}
            if(user[i].equals("HK") || user[i].equals("SK") || user[i].equals("DK") || user[i].equals("CK") || user[i].equals("HQ") || user[i].equals("SQ") || user[i].equals("DQ") || user[i].equals("CQ") )
           {
               u_K_Q = 1;
               break;
           }  
           if(  user[i].equals("HA") || user[i].equals("SA") || user[i].equals("DA") || user[i].equals("CA") )
           {

            u_A = 1;
              break;

           }if( d_K_Q == 1 && d_A ==1){ dealer_try_win =1; break;}

        } 
        
               
        
        //determining results
        if(user_try_win == 1 && dealer_try_win == 1){
          System.out.println("It is a tie as both user and dealer have an ace and face card");
        }else if(user_try_win == 1 && dealer_try_win == 0){
          System.out.println("User wins as user has an ace and face card");
           System.out.println("The users cards are:");
              for(int i=0;i<user.length;i++){
                if(user[i]==null){ break;}
                 System.out.print(user[i] + "  " );
              }
              System.out.println();
            
        }else if(user_try_win == 0 && dealer_try_win == 1){
          System.out.println("Dealer wins as dealer has an ace and face card");
           System.out.println();
             System.out.println("The dealers cards are:");
              for(int i=0;i<dealer.length;i++){
                if(dealer[i]==null){ break;}
                 System.out.print(dealer[i] + "  " );
              }
              System.out.println();

        }else{
          System.out.println("Do you want to end the game \n Press 1 if yes else print 2 \n");
          int choice_abc = scan.nextInt();
          
          if(choice_abc == 1){
          dealer_sum =0;
          user_sum =0;
           for(int i=0;i<dealer.length;i++){
           if(dealer[i]==null){  break; }
           dealer_sum += points(dealer[i].charAt(1));
             } 
   
            for(int i=0;i<user.length;i++){
              if(user[i]==null){  break; }
               user_sum += points(user[i].charAt(1));
             } 
             
              if(dealer_sum>21 && user_sum<=21){
               System.out.println();
               System.out.println();
   
             System.out.println("User wins as delaer has a sum greater than 21"); 
             
              System.out.println("The users cards are:");
                 for(int i=0;i<user.length;i++){
                   if(user[i]==null){ break;}
                    System.out.print(user[i] + "  " );
                 }
                 System.out.println();

             }
             if(user_sum>21 && dealer_sum<=21){
              System.out.println();
              System.out.println();
   
                System.out.println("Dealer wins as user has a sum greater than 21");
                System.out.println();
                System.out.println("The dealers cards are:");
                 for(int i=0;i<dealer.length;i++){
                   if(dealer[i]==null){ break;}
                    System.out.print(dealer[i] + "  " );
                 }
                 System.out.println();
                    
             }
              if(user_sum>21 && dealer_sum>21){
                System.out.println("Dealer and user both loose as they have a sum greater than 21");  
                              
             }
             
             if(user_sum>dealer_sum){
                System.out.println(" User wins as user sum is higher");  
               System.out.println("The users cards are:");
              for(int i=0;i<user.length;i++){
                if(user[i]==null){ break;}
                 System.out.print(user[i] + "  " );
              }
              System.out.println();
                
             }else{
             System.out.println(" Dealer wins as dealer sum is higher"); 
             System.out.println("The dealer cards are:");
              for(int i=0;i<dealer.length;i++){
                if(dealer[i]==null){ break;}
                 System.out.print(dealer[i] + "  " );
              }
              System.out.println();
             }
   
          }
        }
           
       }
       
       if(count_dealer >2){
          
          for(int i=0;i<dealer.length;i++){
           if(dealer[i]==null){  break; }
           dealer_sum += points(dealer[i].charAt(1));
          } 

         for(int i=0;i<user.length;i++){
           if(user[i]==null){  break; }
            user_sum += points(user[i].charAt(1));
          } 
          
           if(dealer_sum>21 && user_sum<=21){
            System.out.println();
            System.out.println();

          System.out.println("User wins as delaer has a sum greater than 21"); 
          
           System.out.println("The users cards are:");
              for(int i=0;i<user.length;i++){
                if(user[i]==null){ break;}
                 System.out.print(user[i] + "  " );
              }
              System.out.println();
           
          }
          if(user_sum>21 && dealer_sum<=21){
           System.out.println();
           System.out.println();

             System.out.println("Dealer wins as user has a sum greater than 21");
             System.out.println();
             System.out.println("The dealers cards are:");
              for(int i=0;i<dealer.length;i++){
                if(dealer[i]==null){ break;}
                 System.out.print(dealer[i] + "  " );
              }
              System.out.println();

                    
          }
           if(user_sum>21 && dealer_sum>21){
             System.out.println("Dealer and user both loose as they have a sum greater than 21");  
             
             System.out.println();
             System.out.println("The dealers cards are:");
              for(int i=0;i<dealer.length;i++){
                if(dealer[i]==null){ break;}
                 System.out.print(dealer[i] + "  " );
              }
              System.out.println();
              
              System.out.println("The users cards are:");
              for(int i=0;i<user.length;i++){
                if(user[i]==null){ break;}
                 System.out.print(user[i] + "  " );
              }
              System.out.println();

              
          }
       }
       
      
           
       }else if(choice ==2 && no_of_deals%5 != 0){
          
          if(dealer_sum>21 && user_sum<=21){
            System.out.println();
            System.out.println();

          System.out.println("User wins as delaer has a sum greater than 21"); 
          
           System.out.println("The users cards are:");
              for(int i=0;i<user.length;i++){
                if(user[i]==null){ break;}
                 System.out.print(user[i] + "  " );
              }
              System.out.println();
          
          }
          else if(user_sum>21 && dealer_sum<=21){
           System.out.println();
           System.out.println();

             System.out.println("Dealer wins as user has a sum greater than 21");
             System.out.println();
             System.out.println("The dealers cards are:");
              for(int i=0;i<dealer.length;i++){
                if(dealer[i]==null){ break;}
                 System.out.print(dealer[i] + "  " );
              }
              System.out.println();
     
          }
          else if(user_sum>21 && dealer_sum>21){
           System.out.println("Both user and dealer loose");  
           System.out.println();            
 
          }else{
           dealer_sum =0; user_sum =0;
           for(int i=0;i<dealer.length;i++){
           if(dealer[i]==null){  break; }
           dealer_sum += points(dealer[i].charAt(1));
          } 

         for(int i=0;i<user.length;i++){
           if(user[i]==null){  break; }
            user_sum += points(user[i].charAt(1));
          } 
          
          if(user_sum>dealer_sum){
                System.out.println(" User wins as user sum is higher");  
               System.out.println("The users cards are:");
              for(int i=0;i<user.length;i++){
                if(user[i]==null){ break;}
                 System.out.print(user[i] + "  " );
              }
              System.out.println();
                
             }else if(user_sum<dealer_sum){
             System.out.println("Dealer wins as dealer sum is higher"); 
             System.out.println("The dealer cards are:");
              for(int i=0;i<dealer.length;i++){
                if(dealer[i]==null){ break;}
                 System.out.print(dealer[i] + "  " );
              }
              System.out.println();
             }else{
             System.out.println("Its a tie"); 
             System.out.println("The dealer cards are:");
              for(int i=0;i<dealer.length;i++){
                if(dealer[i]==null){ break;}
                 System.out.print(dealer[i] + "  " );
              }
              System.out.println();

             System.out.println("The users cards are:");
              for(int i=0;i<user.length;i++){
                if(user[i]==null){ break;}
                 System.out.print(user[i] + "  " );
              }
              System.out.println();

             }

            System.out.println();
          }

          user = user_copy;
          dealer = dealer_copy;
          user = draw(1,cards,user);
          
          no_of_deals++;
          user_count +=1;
          cards = reduce_cards(cards,1,52);

          dealer = draw(1,cards,dealer);
          cards = reduce_cards(cards,1,52);
                   
          System.out.println("The cards given to user  on deal number "+ no_of_deals +" are:");
           for(int i=0;i<user.length;i++){
              if(user[i] == null){ break;}
              System.out.print(user[i] + "  " );
           }
           System.out.println(); 
           
            System.out.println("The cards given to dealer on deal number "+ no_of_deals +" are:");
           for(int i=0;i<dealer.length;i++){
             if(dealer[i] == null){ break;}
              System.out.print(dealer[i] + "  " );
           }
           System.out.println(); 

           count_dealer =1;
           user_count =1;

       }else if(choice ==2 && no_of_deals%5 == 0){
          
         cards = copy_cards;
            if(dealer_sum>21 && user_sum<=21){
            System.out.println();
            System.out.println();

          System.out.println("User wins as delaer has a sum greater than 21"); 
          
           System.out.println("The users cards are:");
              for(int i=0;i<user.length;i++){
                if(user[i]==null){ break;}
                 System.out.print(user[i] + "  " );
              }
              System.out.println();
          
          }
          else if(user_sum>21 && dealer_sum<=21){
           System.out.println();
           System.out.println();

             System.out.println("Dealer wins as user has a sum greater than 21");
             System.out.println();
             System.out.println("The dealers cards are:");
              for(int i=0;i<dealer.length;i++){
                if(dealer[i]==null){ break;}
                 System.out.print(dealer[i] + "  " );
              }
              System.out.println();
     
          }
          else if(user_sum>21 && dealer_sum>21){
           System.out.println("Both user and dealer loose");  
           System.out.println();            
 
          }else{
           dealer_sum =0; user_sum =0;
           for(int i=0;i<dealer.length;i++){
           if(dealer[i]==null){  break; }
           dealer_sum += points(dealer[i].charAt(1));
          } 

         for(int i=0;i<user.length;i++){
           if(user[i]==null){  break; }
            user_sum += points(user[i].charAt(1));
          } 
          
          if(user_sum>dealer_sum){
                System.out.println(" User wins as user sum is higher");  
               System.out.println("The users cards are:");
              for(int i=0;i<user.length;i++){
                if(user[i]==null){ break;}
                 System.out.print(user[i] + "  " );
              }
              System.out.println();
                
             }else if(user_sum<dealer_sum){
             System.out.println("Dealer wins as dealer sum is higher"); 
             System.out.println("The dealer cards are:");
              for(int i=0;i<dealer.length;i++){
                if(dealer[i]==null){ break;}
                 System.out.print(dealer[i] + "  " );
              }
              System.out.println();
             }else{
             System.out.println("Its a tie"); 
             System.out.println("The dealer cards are:");
              for(int i=0;i<dealer.length;i++){
                if(dealer[i]==null){ break;}
                 System.out.print(dealer[i] + "  " );
              }
              System.out.println();

             System.out.println("The users cards are:");
              for(int i=0;i<user.length;i++){
                if(user[i]==null){ break;}
                 System.out.print(user[i] + "  " );
              }
              System.out.println();

             }

            System.out.println();
          }

          user = user_copy;
          dealer = dealer_copy;
          user = draw(1,cards,user);
          
          no_of_deals++;
          user_count +=1;
          cards = reduce_cards(cards,1,52);

          dealer = draw(1,cards,dealer);
          cards = reduce_cards(cards,1,52);
                   
          System.out.println("The cards given to user  on deal number "+ no_of_deals +" are:");
           for(int i=0;i<user.length;i++){
              if(user[i] == null){ break;}
              System.out.print(user[i] + "  " );
           }
           System.out.println(); 
           
            System.out.println("The cards given to dealer on deal number "+ no_of_deals +" are:");
           for(int i=0;i<dealer.length;i++){
             if(dealer[i] == null){ break;}
              System.out.print(dealer[i] + "  " );
           }
           System.out.println(); 

           count_dealer =1;
           user_count =1;
       }else{
         System.out.println("Thanks for playing exit!!!");
         break;
       }
   }
  ///////////////////////////////////////////////////////////////////////
 
 ///////////////////////////////////////////////////////////////////////
 
 }
 
 static String[] shuffle(String array[]){
   Random rnd = new Random();;
   
   for(int i = array.length -1; i > 0; i--){
   	int index = rnd.nextInt(i + 1);
   	//Simple swap
   	String a = array[index];
   	array[index] = array[i];
   	array[i] = a;
   }
   return array;
 }
 
  static String[] reduce_cards(String array[], int beg, int end){
   String[] new_cards =  Arrays.copyOfRange(array, beg, end);
   return new_cards;
 }
 
 static String[] deal(int new_user_count,String[] cards,String[] new_user){
        int j =0;
      for(int i=new_user_count ;i<new_user_count-1+5 ;i++){
       new_user[i]= cards[j];
       j++;
      }     
   
   return new_user;  
  }
 
  static String[] draw(int length,String[] cards,String[] x){ 
     
     int j = length-1;
     for(int i=0;i<1;i++){
       x[j]= cards[i];
       j++;
     }
     
     return x;
  }
  
  static int points(char ch){
     if(ch == 'A'){
       return 1;
     }else if(ch == '2'){
       return 2;
     }else if(ch == '3'){
       return 3;
     }else if(ch == '4'){
       return 4;
     }else if(ch == '5'){
       return 5;
     }else if(ch == '6'){
       return 6;
     }else if(ch == '7'){
       return 7;
     }else if(ch == '8'){
       return 8;
     }else if(ch == '9'){
       return 9;
     }else{
        return 10;
     }
       
  }
 
}