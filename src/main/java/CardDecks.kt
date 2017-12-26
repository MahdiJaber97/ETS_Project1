import java.util.*
fun main(args: Array <String>)
{
    // main function
    var Deck = Deck_of_Cards()  // Deck an instance of the class Deck_of_Cards
    Deck.InitializeDeck()       // Initializing a new Deck
    //Deck.displayCards()       // The function will print out the whole deck
    Deck.shuffle()              // The function will shuffle the deck of cards
    Deck.displayCards()
    println("///////////////////////////////////////////////////////////////////////////////")
    for(i in 0..53)             // We will deal a card for 54 times
        Deck.dealOneCard()      // The function deals one card to the user
}
class Deck_of_Cards             // Class for Card Decks
{
    var Cards = Array<Card>(52, { i -> Card() })    // An array of 52 instances of the Cards Class
    fun suitName(a:Int):String  // The function returns the suit name of the Card
    {
        return Cards[a].suit;
    }
    fun FaceValueName(a:Int):String // The function returns the face value of the Card
    {
        return Cards[a].Face_Value;
    }
    fun displayCards()  // The function displays all cards of the deck
    {
        for (i in 1..52)
            Cards[i - 1].display()
    }
    fun shuffle()   // The function shuffles the cards
    {
        for(i in 0..51)
        {
            var rand1= rand(0,51)   // The shuffling takes place according to a random number between 0 and 51
            this.Cards[i].swapCards(this.Cards[rand1])  //Two cards are swapped according to the random number and the variable i
        }
    }
    fun dealOneCard()   // The function delivers a Card from the deck to the user
    {
        var rand1= rand(0,51)   // generating a random number
        var i:Int=0 // variable to check the remaining number of Cards in the deck
        while(this.Cards[rand1].suit=="Null"&& i<52)    // A while loop to keep checking for Cards
        {
            i++ // Incrementing the variable
            if(rand1==51)   //  Not to increment above 51 and exceed the range of the array of Cards
                rand1=0
            else rand1++    // If this Card was taken (Null,Null) then we check the next Card
        }
        if(i==52)   // We have to check if we have checked 52 times then we know no more Cards are left
        {
            println("There are no more cards in the deck!")
        }
        else    // Else we display the Card number rand1 and change it to (Null,Null) to sign it as taken
        {
            this.Cards[rand1].display() // Display the random Card
            this.Cards[rand1].init("Null","Null")   // Initialize it to (Null,Null)
        }
    }
    fun InitializeDeck()    // The function to Initialize a Deck
    {
        var i=0 // Initialize the Number of the Card being initialized
        for (k in 0..3) // Variable to show which suit we are operating on
        {
            for (j in 0..12)    // Variable to show which Face_Value we are operating on
            {
                var suit= selectSuit(k) // Select suit of the Card according to the variable k
                var Face_Value= selectFaceValue(j)  // Select Face Value of the Card according to the value j
                Cards[i].init(suit,Face_Value)  //  Initialize the Card
                i++ //  Increment i
            }
        }
    }
    fun NumberofCard(suit:String,Face_Value1: String):Int   // The function that gives the Card a certain number according to its suit and Face Value
    {
        if(suit=="Hearts"&&Face_Value1=="Ace")
            return 1
        else if (suit=="Hearts"&&Face_Value1=="2")
            return 2
        else if (suit=="Hearts"&&Face_Value1=="3")
            return 3
        else if (suit=="Hearts"&&Face_Value1=="4")
            return 4
        else if (suit=="Hearts"&&Face_Value1=="5")
            return 5
        else if (suit=="Hearts"&&Face_Value1=="6")
            return 6
        else if (suit=="Hearts"&&Face_Value1=="7")
            return 7
        else if (suit=="Hearts"&&Face_Value1=="8")
            return 8
        else if (suit=="Hearts"&&Face_Value1=="9")
            return 9
        else if (suit=="Hearts"&&Face_Value1=="10")
            return 10
        else if (suit=="Hearts"&&Face_Value1=="Jack")
            return 11
        else if (suit=="Hearts"&&Face_Value1=="Queen")
            return 12
        else if(suit=="Hearts"&&Face_Value1=="King")
            return 13
        else if(suit=="Diamonds"&&Face_Value1=="Ace")
            return 14
        else if (suit=="Diamonds"&&Face_Value1=="2")
            return 15
        else if (suit=="Diamonds"&&Face_Value1=="3")
            return 16
        else if (suit=="Diamonds"&&Face_Value1=="4")
            return 17
        else if (suit=="Diamonds"&&Face_Value1=="5")
            return 18
        else if (suit=="Diamonds"&&Face_Value1=="6")
            return 19
        else if (suit=="Diamonds"&&Face_Value1=="7")
            return 20
        else if (suit=="Diamonds"&&Face_Value1=="8")
            return 21
        else if (suit=="Diamonds"&&Face_Value1=="9")
            return 22
        else if (suit=="Diamonds"&&Face_Value1=="10")
            return 23
        else if (suit=="Diamonds"&&Face_Value1=="Jack")
            return 24
        else if (suit=="Diamonds"&&Face_Value1=="Queen")
            return 25
        else if(suit=="Diamonds"&&Face_Value1=="King")
            return 26
        else if(suit=="Clubs"&&Face_Value1=="Ace")
            return 27
        else if (suit=="Clubs"&&Face_Value1=="2")
            return 28
        else if (suit=="Clubs"&&Face_Value1=="3")
            return 29
        else if (suit=="Clubs"&&Face_Value1=="4")
            return 30
        else if (suit=="Clubs"&&Face_Value1=="5")
            return 31
        else if (suit=="Clubs"&&Face_Value1=="6")
            return 32
        else if (suit=="Clubs"&&Face_Value1=="7")
            return 33
        else if (suit=="Clubs"&&Face_Value1=="8")
            return 34
        else if (suit=="Clubs"&&Face_Value1=="9")
            return 35
        else if (suit=="Clubs"&&Face_Value1=="10")
            return 36
        else if (suit=="Clubs"&&Face_Value1=="Jack")
            return 37
        else if (suit=="Clubs"&&Face_Value1=="Queen")
            return 38
        else if(suit=="Clubs"&&Face_Value1=="King")
            return 39
        else if(suit=="Spades"&&Face_Value1=="Ace")
            return 40
        else if (suit=="Spades"&&Face_Value1=="2")
            return 41
        else if (suit=="Spades"&&Face_Value1=="3")
            return 42
        else if (suit=="Spades"&&Face_Value1=="4")
            return 43
        else if (suit=="Spades"&&Face_Value1=="5")
            return 44
        else if (suit=="Spades"&&Face_Value1=="6")
            return 45
        else if (suit=="Spades"&&Face_Value1=="7")
            return 46
        else if (suit=="Spades"&&Face_Value1=="8")
            return 47
        else if (suit=="Spades"&&Face_Value1=="9")
            return 48
        else if (suit=="Spades"&&Face_Value1=="10")
            return 49
        else if (suit=="Spades"&&Face_Value1=="Jack")
            return 50
        else if (suit=="Spades"&&Face_Value1=="Queen")
            return 51
        else if(suit=="Spades"&&Face_Value1=="King")
            return 52
        else return 0
    }
}
class Card()    // Class for each Card
{
    var suit:String="Null"  // The suit of the Card
    var Face_Value:String="Null"    // The Face Value of the Card
    fun init(suit1:String,Face_Value1:String)   // The function to initialize the Card
    {
        suit=suit1
        Face_Value=Face_Value1
    }
    fun display()   // The function to display a certain a certain Card
    {
        println("Your card is $suit,$Face_Value")
    }
    fun swapCards (Card2:Card)  // The function to swap two Cards by swapping their Suits and Face Values
    {
        var suit1:String
        var facevalue:String
        suit1=Card2.suit
        facevalue=Card2.Face_Value
        Card2.suit=this.suit
        Card2.Face_Value=this.Face_Value
        this.suit=suit1
        this.Face_Value=facevalue
    }
}
fun selectSuit(num:Int):String  //  The function to give a number according to the suit of the Card
{
    if(num==0)
        return "Hearts"
    else if(num==1)
        return "Spades"
    else if(num==2)
        return "Clubs"
    else if(num==3)
        return "Diamonds"
    else return "Null"
}
fun selectFaceValue(num:Int):String // The function to give a number according to the Face Value
{
    if(num==0)
        return "Ace"
    else if(num==1)
        return "2"
    else if(num==2)
        return "3"
    else if(num==3)
        return "4"
    else if(num==4)
        return "5"
    else if(num==5)
        return "6"
    else if(num==6)
        return "7"
    else if(num==7)
        return "8"
    else if(num==8)
        return "9"
    else if(num==9)
        return "10"
    else if(num==10)
        return "Jack"
    else if(num==11)
        return "Queen"
    else if(num==12)
        return "King"
    else return "Null"
}
fun rand(from: Int, to: Int) : Int  // The function that generates a random number
{
    return Random().nextInt(to - from)
}