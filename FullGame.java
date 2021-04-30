/** FullGame.java
 * Description: This is the full gameplay of my culminating. From start to finish, everything is in this file!
 *
 *
 * @author N. Kowal
 * @version 1.1 (Last Updated: Feb 24, 2020): Made changes to audio files so to better work on multiple IDEs
 **/
import java.awt.*;
import hsa_ufa.Console;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class FullGame{

    public static Console c;

    //console sizes
    public static final int CONSOLE_WIDTH = 1000;
    public static final int CONSOLE_HEIGHT = 900;

    //number of program "crashes" by the user
    public static int programCrashes = 0;

    //number of samples collected by the user
    public static int samplesCollected = 0;

    public static void headphoneMessage() throws InterruptedException, IOException, FontFormatException {
        /** headphoneMessage
         * Description: This method tells the user that the game is better with headphones
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         **/

        //clears the background
        c.setBackgroundColor(new Color(59, 190, 247)); //background colour (light blue)
        c.clear();

        c.setColor(new Color(54, 40, 239));
        Font astro = Font.createFont(Font.TRUETYPE_FONT, FullGame.class.getResourceAsStream("Astro.ttf"));
        c.setFont(astro.deriveFont(Font.PLAIN, 30));
      //  c.setFont(new Font("/Users/nathankowal/Documents/CodeProjects/11Culm/src/ASTRO.ttf", Font.PLAIN, 20));
        c.drawString("This game is better with headphones", CONSOLE_WIDTH/2 - 200, CONSOLE_HEIGHT/2);

        Thread.sleep(2500);
    }

    public static void randomDraw() throws InterruptedException {

        /** randomDraw
         * Description: This method draws random circles around the screen
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         **/

        int x, y, radius;
        c.setColor(new Color(86, 164, 247));

        for(int i = 1; i <= 100; i ++){
            x = (int) (Math.random() * 900 + 25);
            y = (int) (Math.random() * 600 + 25);
            radius = (int) (Math.random() * 25 + 10);
            c.fillOval(x, y, radius, radius);

            Thread.sleep(40);
        }
    }

    public static void drawTitle(int x, int y) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** drawTitle
         * Description: This method draws the title
         *
         * @ x
         * the x position of the title
         *
         * @ y
         * the y position of the title
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws InterruptedException
         * For playing music
         **/

        headphoneMessage();

        //clears the background
        c.setBackgroundColor(new Color(59, 190, 247)); //background colour (light blue)
        c.clear();

        //code to start the music
        File sound1 = new File ("/Users/nathankowal/Documents/CodeProjects/11Culm/src/titleMusic.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(sound1);

        AudioFormat format = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip audioClip = (Clip) AudioSystem.getLine(info);

        audioClip.open(audioStream);
        audioClip.start();

        Thread.sleep(1500);

        //draws the purple title
        c.setColor(new Color(108, 95, 232));
       // c.setFont(new Font("ELIXIA", Font.PLAIN, 200));
        Font elixia = Font.createFont(Font.TRUETYPE_FONT, FullGame.class.getResourceAsStream("ELIXIA.ttf"));
        c.setFont(elixia.deriveFont(Font.PLAIN, 200));
        c.drawString("THE BLURB", x - 125, y);

        //draws the random circles
        randomDraw();

        //waits before redrawing the title blue
        Thread.sleep(500);

        //makes the text "flash" blue
        c.setColor(new Color(54, 40, 239));
        c.setFont(elixia.deriveFont(Font.PLAIN, 200));
        c.drawString("THE BLURB", x - 125, y);

        //delay between the flashes
        Thread.sleep(50);

        //turns the text back to purple
        c.setColor(new Color(108, 95, 232));
        c.setFont(elixia.deriveFont(Font.PLAIN, 200));
        c.drawString("THE BLURB", x - 125, y);

        //waits before turning the text back to blue, the final colour
        Thread.sleep(750);

        //turns the the text back to blue and makes the subtitle appear
        c.setColor(new Color(54, 40, 239));
        c.setFont(elixia.deriveFont(Font.PLAIN, 200));
        c.drawString("THE BLURB", x - 125, y);

        c.setFont(elixia.deriveFont(Font.PLAIN, 75));
        c.drawString("a text adventure game", x - 90, y + 100);

        Thread.sleep(2000);

        c.setColor(new Color(54, 40, 239));
        c.setFont(elixia.deriveFont(Font.PLAIN, 25));
        c.drawString("Press any key to start", x + 100, y + 300);

        c.getChar();

        //stop the music
        audioClip.close();
        audioStream.close();

    }

    public static void openingCredits(int cWidth, int cHeight) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException, FontFormatException {

        /** drawTitle
         * Description: This method draws the title
         *
         * @ cWidth
         * console width
         *
         * @ cHeight
         * console height
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws InterruptedException
         * For playing music
         **/



        String openingMessage [] = {"It is a stressful time for the human race. The technologically advanced super-metropolis of",
                "FORAMOR has become overcrowded and overpopulated. The high birth rates and low death", "rates have led to a mid 6th century population boom, the biggest for humankind since",
                "venturing to their new home world, JANUS. The government of Foramor lacks sufficient funds",
                "to build more infrastructure for this spike in population.", "\n",
                "However, there is hope. The government has tasked the colony’s most gifted scientist, biologist", "Dr. Zoë Adams, to search for a location to found a new city and save the human race. She has",
                "assembled a team: Akari Hakyen, a botanist, Hudson Rain, a chemist, and Mikayla Deivass, a",
                "photographer and journalist. Together, they will embark on a mission into SECTOR 18-b, a",
                "previously unexplored region of Foramor referred to by locals as THE BLURB. In order to make",
                "it through and achieve their goals, they will need to remain in touch with their communications",
                "officer back in Foramor… "};


        c.clear();

        Thread.sleep(1500);

        c.setColor(new Color(54, 40, 239));
        Font astro = Font.createFont(Font.TRUETYPE_FONT, FullGame.class.getResourceAsStream("Astro.ttf"));
        c.setFont(astro.deriveFont(Font.PLAIN, 20));
        c.drawString("A short time in the future in a galaxy close, close to home", cWidth/2 - 225, cHeight/2);

        Thread.sleep(3000);
        c.clear();

        //code to start the music
        //code to start the music
        File sound2 = new File ("/Users/nathankowal/Documents/CodeProjects/11Culm/src/OpeningCreditsMusic.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(sound2);

        AudioFormat format = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip audioClip = (Clip) AudioSystem.getLine(info);

        audioClip.open(audioStream);
        audioClip.start();

        c.setColor(new Color(54, 40, 239));
        c.setFont(astro.deriveFont(Font.PLAIN, 100));
        c.drawString("THE BLURB", cWidth/2 - 175, cHeight/2);

        Thread.sleep(3000);

        c.setColor(new Color(54, 40, 239));
        c.setFont(astro.deriveFont(Font.PLAIN, 25));

        for(int y = cHeight + 50; y >= -400; y -=2){

            for(int i = 0; i < openingMessage.length; i ++){

                c.drawString(openingMessage[i], 100, y + i * 30);
            }

            Thread.sleep(50);
            c.clear();

        }

        Thread.sleep(2000);

        //stop the music
        audioClip.close();
        audioStream.close();
    }

    public static void drawBackground () throws InterruptedException{

        /** drawConsole
         * Description: This method draws the console that the user sees
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         **/

        //arrays containing the x and y positions of the background shapes
        int polygonX[] = {50, 120, 445, 455, 545, 555, 950, 950, 880, 600, 590, 410, 400, 60, 50};
        int polygonY[] = {120, 50, 50, 60, 60, 50, 50, 580, 650, 650, 640, 640, 650, 650, 640};

        int polygon2x[] = {40, 110, 425, 435, 565, 575, 960, 960, 890, 50, 40};
        int polygon2y[] = {110, 40, 40, 35, 35, 40, 40, 590, 660, 660, 650};

        c.setBackgroundColor(new Color(59, 190, 247)); //background colour (light blue)
        c.clear();

        c.setColor(new Color(54, 40, 239)); //dark blue

        //draws the polygons
        c.drawPolygon(polygonX, polygonY, 15);
        c.drawPolygon(polygon2x, polygon2y, 11);

        //draws the small line in the bottom left corner
        c.drawLine(25, 550, 25, 650);
        c.drawArc(25, 625, 50, 50, 180, 90);
        c.drawLine(50, 675, 140, 675);

        //draws the rectangles on the right side of the screen
        for(int y = 250; y < 550; y += 43){
            c.drawRect(981, y, 9, 40);
            c.drawRect(970, y, 9, 40);
        }

        c.setColor(new Color(54, 40, 239)); //dark blue

        //draws the rounded rectangles on the left side of the screen
        for(int y = 150; y < 500; y +=10){
            c.fillRoundRect(-5, y, 35, 5, 3, 3);
        }

        //draws the small squares at the top of the screen
        for(int x = 700; x <= 868; x +=12){
            for(int y = 10; y <= 22; y += 12){

                //this if-else statement randomly fills the rectangle, or draws just the border
                if(Math.random() > 0.5){
                    c.fillRoundRect(x, y, 10, 10, 3, 3);
                } else {
                    c.drawRoundRect(x, y, 10, 10, 3, 3);
                }
            }
        }

        //transmission text
        c.setCursor(5, 17);
        c.print("Transmission:");

        //transmission connected
        c.setCursor(5, 30);
        c.setColor(new Color(54, 40, 239));
        c.print(" Connected");

    }

    public static void openConsole () throws InterruptedException{

        /** drawConsole
         * Description: This method draws the console that the user sees
         *
         *
         * @ random
         * a random number that is generated
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         **/

        //arrays containing the x and y positions of the background shapes
        int polygonX[] = {50, 120, 445, 455, 545, 555, 950, 950, 880, 600, 590, 410, 400, 60, 50};
        int polygonY[] = {120, 50, 50, 60, 60, 50, 50, 580, 650, 650, 640, 640, 650, 650, 640};

        int polygon2x[] = {40, 110, 425, 435, 565, 575, 960, 960, 890, 50, 40};
        int polygon2y[] = {110, 40, 40, 35, 35, 40, 40, 590, 660, 660, 650};

        c.setBackgroundColor(new Color(59, 190, 247)); //background colour (light blue)
        c.clear();

        c.setColor(new Color(54, 40, 239)); //dark blue

        //draws the polygons
        c.drawPolygon(polygonX, polygonY, 15);
        c.drawPolygon(polygon2x, polygon2y, 11);

        //draws the small line in the bottom left corner
        c.drawLine(25, 550, 25, 650);
        c.drawArc(25, 625, 50, 50, 180, 90);
        c.drawLine(50, 675, 140, 675);

        //draws the rectangles on the right side of the screen
        for(int y = 250; y < 550; y += 43){
            c.drawRect(981, y, 9, 40);
            c.drawRect(970, y, 9, 40);

        }

        c.setColor(new Color(54, 40, 239)); //dark blue

        //draws the rounded rectangles on the left side of the screen
        for(int y = 150; y < 500; y +=10){
            c.fillRoundRect(-5, y, 35, 5, 3, 3);
        }

        //draws the small squares at the top of the screen
        for(int x = 700; x <= 868; x +=12){
            for(int y = 10; y <= 22; y += 12){
                if(Math.random() > 0.5){

                    //this if-else statement randomly fills the rectangle, or draws just the border
                    c.fillRoundRect(x, y, 10, 10, 3, 3);
                } else {
                    c.drawRoundRect(x, y, 10, 10, 3, 3);
                }
            }
        }

        //transmission text
        c.setCursor(5, 17);
        c.print("Transmission:");

        //to make text flash
        for(int i = 0; i < 10; i ++){

            c.setCursor(5, 30);

            if(i % 2 == 0){
                c.setColor(new Color(54, 40, 239)); //dark blue
                c.print(" Connecting...");

            } else {
                c.setColor(new Color(59, 190, 247)); //background colour (light blue)
                c.print(" Connecting...");
            }

            Thread.sleep(500);
        }

        //transmission connected
        c.setCursor(5, 30);
        c.setColor(new Color(54, 40, 239));
        c.print(" Connected");

    }

    public static void sequenceOne() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** sequenceOne
         * Description: This method draws the first message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "This is Dr. Adams, reporting that we have safely arrived in sector 18-b. Around us, we see a lush jungle, as expected from our satelitle photos and previous border expeditions. I am alongside Akira Hakyen, Hudson Rain,and Mikayla Deivass. We will embark into the Blurb as soon as we have the all clear from communications back in Foramor.";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        //first message from the user
        String userMessage = "This is ground control in Foramor. I have received your message and you are all clear to move forth with the mission.";

        //splits the message into individual characters
        String userArray1[] = userMessage.split("");

        //splits the message into strings of 109 characters
        String userArray1a[] = userMessage.split("(?<=\\G.{109})");

        //second message from the computer
        String computerMessageTwo = "Thank you. To interact with this console from now on, type instructions into it. If you need help now you mayenter \"help\". If you understand this message, please confirm by typing \"okay\".";

        //splits the message into individual characters
        String computerArray2[] = computerMessageTwo.split("");

        //splits the message into strings of 109 characters
        String computerArray2a[] = computerMessageTwo.split("(?<=\\G.{109})");

        //declares a string that will hold the user's answer
        String userAnswer;

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 218:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[1]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 327:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[2]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
                case 338:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerOneFinal(45, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
            }

        }

        //prints the first user message one character at a time
        for(int i = 0; i < userArray1.length; i ++){

            //the print statement
            c.print(userArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerOneFinal(44, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(userArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 117:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerOneFinal(42, blank, computerArray1a);

                    //calls the method for the final form of the first user message
                    userOneFinal(47, blank, userArray1a);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
            }
        }

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints the second computer message one character at a time
        for(int i = 0; i < computerArray2.length; i ++){

            //the print statement
            c.print(computerArray2[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerOneFinal(41, blank, computerArray1a);

                    //calls the method for the final form of the first user message
                    userOneFinal(46, blank, userArray1a);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray2a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 195:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerOneFinal(39, blank, computerArray1a);

                    //calls the method for the final form of the user computer message
                    userOneFinal(44, blank, userArray1a);

                    //calls the method for the final form of the second computer message
                    computerTwoFinal(47, blank, computerArray2a);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);

            }

        }

        //boolean value if the user's answer is valid
        boolean valid = true;

        //y coordinate of the text to be used in the loop below
        int yCoordinate = 39;

        //amount of times the user fails to enter one of the options
        int failCount = 0;

        //string containing all previous invalid answers from the user
        String invalidAnswers[] = {"", "", ""};

        //string that will contain the user's response
        String response;

        //do-while loop for the user's answer
        do{

            //calls the method for the final form of the first computer message
            computerOneFinal(yCoordinate, blank, computerArray1a);

            //calls the method for the final form of the first user message
            userOneFinal(yCoordinate + 5, blank, userArray1a);

            //calls the method for the final form of the second computer message
            computerTwoFinal(yCoordinate + 8, blank, computerArray2a);

            //prints a blank line
            c.setCursor(50, 15);
            c.print(blank);

            //resets the cursor back to original spot
            c.setCursor(50, 15);
            c.setColor(new Color(250, 250, 250)); //white

            //reads the user's answer
            userAnswer = c.readToken();

            //draws the background again (to cover the part that gets cut off)
            drawBackground();

            //prints a blank line over the original text
            c.setCursor(50, 15);
            c.print(blank);



            //if the user's answer is "help"
            if(userAnswer.equalsIgnoreCase("help")){

                //set valid to true (stop the loop from running again)
                valid = true;

                //calls the method for the final form of the first computer message
                computerOneFinal(yCoordinate - 2, blank, computerArray1a);

                //calls the method for the final form of the first user message
                userOneFinal(yCoordinate + 3, blank, userArray1a);

                //calls the method for the final form of the second computer message
                computerTwoFinal(yCoordinate + 6, blank, computerArray2a);

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(48, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //string containing the computer's response
                response = "Enter command words such as \"get\", \"examine\", or \"go\", and an object to guide me through the Blurb.";

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(50, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){

                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                }
            }

            //if the user's answer is "okay"
            else if(userAnswer.equalsIgnoreCase("okay"))  {

                //set valid to true (stop the loop from running again)
                valid = true;

                //calls the method for the final form of the first computer message
                computerOneFinal(yCoordinate - 2, blank, computerArray1a);

                //calls the method for the final form of the first user message
                userOneFinal(yCoordinate + 3, blank, userArray1a);

                //calls the method for the final form of the second computer message
                computerTwoFinal(yCoordinate + 6, blank, computerArray2a);

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(48, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //string containing the computer's response
                response = "Moving on.";

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(50, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }
            }

            //if the user's answer is anything else
            else {

                //set valid to false (the loop will continue running)
                valid = false;

                //increase fail count by 1
                failCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 8, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 9, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 10, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 11, 15);
                c.print(blank);

                //calls the method for the final form of the first computer message
                computerOneFinal(yCoordinate, blank, computerArray1a);

                //calls the method for the final form of the first user message
                userOneFinal(yCoordinate + 5, blank, userArray1a);

                //calls the method for the final form of the second computer message
                computerTwoFinal(yCoordinate + 8, blank, computerArray2a);

                //switch statement depending on the fail count
                switch(failCount){
                    case 1:
                        //set the first entry in the array to the current user answer
                        invalidAnswers[0] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[0]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 2:
                        //set the second entry in the array to the current user answer
                        invalidAnswers[1] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[1]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 3:
                        //set the third entry in the array to the current user answer
                        invalidAnswers[2] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[2]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        //to make the text flash
                        for(int i = 0; i < 10; i ++){

                            //resets the cursor back to original spot
                            c.setCursor(50, 15);

                            if(i % 2 == 0){

                                c.setColor(new Color(54, 40, 239)); //dark blue
                                c.print("System Error");

                            } else {
                                c.setColor(new Color(59, 190, 247)); //background colour (light blue)
                                c.print("System Error");
                            }

                            Thread.sleep(200);
                        }

                        //set valid to true (stop the loop from running again)
                        valid = true;

                        //run the method crashed. It will end the program and start sequence one all over again
                        crashed(1);
                        break;
                }

            }


        } while (!valid); //runs the loop while valid is false

        Thread.sleep(2000);
        drawBackground();

    }

    public static void computerOneFinal (int r, String blank, String computerArray1a[]){

        /** computerOneFinal
         * Description: This method draws the final form of the first computer message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerArray1a[] the array to print (from message one)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setCursor(r + 2, 15);
        c.print(blank);

        c.setCursor(r + 3, 15);
        c.print(blank);

        c.setCursor(r + 4, 15);
        c.print(blank);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints all lines of the first computer message
        c.setCursor(r, 15);
        c.print(computerArray1a[0]);

        c.setCursor(r + 1, 15);
        c.print(computerArray1a[1]);

        c.setCursor(r + 2, 15);
        c.print(computerArray1a[2]);

        c.setCursor(r + 3, 15);
        c.print(computerArray1a[3]);
    }

    public static void userOneFinal (int r, String blank, String userArray1a[]){

        /** userOneFinal
         * Description: This method draws the final form of the first user message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ userArray1a[] the array to print (from message one)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setCursor(r + 2, 15);
        c.print(blank);

        c.setColor(new Color(250, 250, 250)); //dark blue

        //prints all lines of the first user message
        c.setCursor(r, 15);
        c.print(userArray1a[0]);

        c.setCursor(r + 1, 15);
        c.print(userArray1a[1]);
    }

    public static void computerTwoFinal (int r, String blank, String computerArray2a[]){
        /** computerTwoFinal
         * Description: This method draws the final form of the second computer message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerArray2a[] the array to print (from message one)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setCursor(r + 2, 15);
        c.print(blank);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints all lines of the second computer message
        c.setCursor(r, 15);
        c.print(computerArray2a[0]);

        c.setCursor(r + 1, 15);
        c.print(computerArray2a[1]);
    }

    public static void sequenceTwo() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** sequenceTwo
         * Description: This method draws the second message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "Just a reminder: my team has two main objectives while here in the Blurb. Firstly, we need to find a spot to establish a new human city. This will be our primary focus. Our secondary focus is collecting samples of eve-rything that we possibly can to send back to the lab for testing. We are approaching the edge of a large cli-ff. To the right, there is a small grove of tall trees. To the left, a strange purple liquid flows over the  cliff in a waterfall. We need to get down the cliff, how should we do it? To check what we have in our inven-tory, type \"inventory\" at any time.";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        //declares a string that will hold the user's answer
        String userAnswer;

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 218:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[1]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 327:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[2]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 436:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(46, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[2]);

                    //prints the fourth line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[3]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 545:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(45, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(46, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[2]);

                    //prints the fourth line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[3]);

                    //prints the fifth line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[4]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
                case 580:

                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(43, blank, computerArray1a);

            }

        }

        //boolean value if the user's answer is valid
        boolean valid = true;

        //boolean value if the user has sampled the purple liquid
        boolean purpleLiquidSampled = false;

        //boolean value for if the user has asked for an inventory check
        boolean checkedInventory = false;

        //integer value for how many steps the user has completed
        int stepsCompleted = 0;

        //integer value for number of valid answers the user has entered
        int validAnswerCount = 0;

        //array containing all previous valid answers from the user
        String validAnswers[] = {"", "", "", "", ""};

        //array containing all previous valid respones from the computer
        String validResponses[] = {"", "", "", "", ""};

        //y coordinate of the text to be used in the loop below
        int yCoordinate = 43;

        //amount of times the user fails to enter one of the options
        int failCount = 0;

        //array containing all previous invalid answers from the user
        String invalidAnswers[] = {"", "", ""};

        //string that will contain the user's response
        String response;

        //do-while loop for the user's answer
        do{

            //resets the cursor back to original spot
            c.setCursor(50, 15);
            c.setColor(new Color(250, 250, 250)); //white

            //reads the user's answer
            userAnswer = c.readLine();

            //draws the background again (to cover the part that gets cut off)
            drawBackground();

            //prints a blank line over the original text
            c.setCursor(50, 15);
            c.print(blank);

            //if the user's answer is "inventory" and the inventory has not been checked already
            if(userAnswer.contains("inventory") && !checkedInventory){

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //set checkedInventory to true, so this cannot be entered again
                checkedInventory = true;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Inventory: Some rope, empty containers, flashlight, camping supplies.";

                if(stepsCompleted == 2){
                    //string containing the computer's response
                    response = "Inventory: Empty containers, flashlight, camping supplies.";
                }

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //set the first entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[1]);


                }

                if(validAnswerCount == 3){

                    //set the first entry in the array to the current user answer
                    validAnswers[2] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[2] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 12, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[2]);
                }

                if(validAnswerCount == 4){

                    //set the fourth entry in the array to the current user answer
                    validAnswers[3] = userAnswer;

                    //set the fourth entry in the array to the current response
                    validResponses[3] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 16, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 9, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[2]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[3]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5,  15);
                    c.print(validResponses[3]);
                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){

                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                }

            }

            //if the user's answer is to sample the purple liquid and the sample has not already been collected
            else if(userAnswer.contains("sample") && userAnswer.contains("liquid") && userAnswer.contains("purple") && !purpleLiquidSampled){

                samplesCollected += 1;

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //set purpleLiquidSample to true, so this cannot be entered again
                purpleLiquidSampled = true;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Sample of the purple liquid collected.";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //set the first entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[1]);

                }

                if(validAnswerCount == 3){

                    //set the third entry in the array to the current user answer
                    validAnswers[2] = userAnswer;

                    //set the third entry in the array to the current response
                    validResponses[2] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 12, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[2]);
                }

                if(validAnswerCount == 4){

                    //set the fourth entry in the array to the current user answer
                    validAnswers[3] = userAnswer;

                    //set the fourth entry in the array to the current response
                    validResponses[3] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 16, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 9, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[2]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[3]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5,  15);
                    c.print(validResponses[3]);
                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){

                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                }

            }

            //if the user's answer is to examine the trees
            else if(userAnswer.contains("trees") && (userAnswer.contains("examine") || userAnswer.contains("go to") || userAnswer.contains("look at")) && stepsCompleted == 0)  {

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                //string containing the computer's response
                response = "I'll have Akira take a look... she says the trees are sturdy and can support our weight. What next?";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //set the first entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[1]);

                }

                if(validAnswerCount == 3){

                    //set the third entry in the array to the current user answer
                    validAnswers[2] = userAnswer;

                    //set the third entry in the array to the current response
                    validResponses[2] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 12, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[2]);
                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }

                //step one is complete
                stepsCompleted = 1;
            }

            //if the user's answer is to tie the rope ot the tree
            else if(userAnswer.contains("rope") && (userAnswer.contains("tree") || userAnswer.contains("trees")) && (userAnswer.contains("tie") || userAnswer.contains("attach")) && stepsCompleted == 1)  {

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Tied the rope to a tree. What next?";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //set the first entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[1]);

                }

                if(validAnswerCount == 3){

                    //set the third entry in the array to the current user answer
                    validAnswers[2] = userAnswer;

                    //set the third entry in the array to the current response
                    validResponses[2] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 12, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[2]);
                }

                if(validAnswerCount == 4){

                    //set the fourth entry in the array to the current user answer
                    validAnswers[3] = userAnswer;

                    //set the fourth entry in the array to the current response
                    validResponses[3] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 16, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 9, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[2]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[3]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5,  15);
                    c.print(validResponses[3]);
                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }

                //step two is complete
                stepsCompleted = 2;
            }

            //if the user's answer is to tie the rope ot the tree
            else if((userAnswer.contains("go down") || userAnswer.contains("descend")) && stepsCompleted == 2)  {

                //set valid to ture (the loop will stop running)
                valid = true;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Going down...";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //set the second entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the second entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[1]);

                }

                if(validAnswerCount == 3){

                    //set the third entry in the array to the current user answer
                    validAnswers[2] = userAnswer;

                    //set the third entry in the array to the current response
                    validResponses[2] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 12, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[2]);
                }

                if(validAnswerCount == 4){

                    //set the fourth entry in the array to the current user answer
                    validAnswers[3] = userAnswer;

                    //set the fourth entry in the array to the current response
                    validResponses[3] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 16, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 9, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[2]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[3]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5,  15);
                    c.print(validResponses[3]);
                }

                if(validAnswerCount == 5){

                    //set the fifth entry in the array to the current user answer
                    validAnswers[4] = userAnswer;

                    //set the fifth entry in the array to the current response
                    validResponses[4] = response;

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 20, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 13, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 11, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 9, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate -  3, 15);
                    c.print(validResponses[2]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[3]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1,  15);
                    c.print(validResponses[3]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[4]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5,  15);
                    c.print(validResponses[4]);
                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }

                //step three is complete
                stepsCompleted = 3;
            }

            //if the user's answer is anything else
            else {

                //set valid to false (the loop will continue running)
                valid = false;

                //increase fail count by 1
                failCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                if(validAnswerCount == 0){

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate, blank, computerArray1a);
                }

                if(validAnswerCount == 1){

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[1]);

                }

                if(validAnswerCount == 3){

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 12, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5, 15);
                    c.print(validResponses[2]);
                }

                if(validAnswerCount == 4){

                    //calls the method for the final form of the first computer message
                    computerThreeFinal(yCoordinate - 16, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 9, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validResponses[2]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validAnswers[3]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 5,  15);
                    c.print(validResponses[3]);
                }

                //switch statement depending on the fail count
                switch(failCount){
                    case 1:
                        //set the first entry in the array to the current user answer
                        invalidAnswers[0] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[0]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 2:
                        //set the second entry in the array to the current user answer
                        invalidAnswers[1] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[1]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 3:
                        //set the third entry in the array to the current user answer
                        invalidAnswers[2] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[2]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        //to make the text flash
                        for(int i = 0; i < 10; i ++){

                            //resets the cursor back to original spot
                            c.setCursor(50, 15);

                            if(i % 2 == 0){

                                c.setColor(new Color(54, 40, 239)); //dark blue
                                c.print("System Error");

                            } else {
                                c.setColor(new Color(59, 190, 247)); //background colour (light blue)
                                c.print("System Error");
                            }

                            Thread.sleep(200);
                        }

                        //set valid to true (stop the loop from running again)
                        valid = true;

                        //run the method crashed. It will end the program and start sequence two all over again
                        crashed(2);
                        break;
                }

            }

        } while (!valid); //runs the loop while valid is false

        Thread.sleep(2000);
        drawBackground();
    }

    public static void computerThreeFinal (int r, String blank, String computerArray1a[]){

        /** computerThreeFinal
         * Description: This method draws the final form of the third computer message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerArray1a[] the array to print (from message one)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setCursor(r + 2, 15);
        c.print(blank);

        c.setCursor(r + 3, 15);
        c.print(blank);

        c.setCursor(r + 4, 15);
        c.print(blank);

        c.setCursor(r + 5, 15);
        c.print(blank);

        c.setCursor(r + 6, 15);
        c.print(blank);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints all lines of the third computer message
        c.setCursor(r, 15);
        c.print(computerArray1a[0]);

        c.setCursor(r + 1, 15);
        c.print(computerArray1a[1]);

        c.setCursor(r + 2, 15);
        c.print(computerArray1a[2]);

        c.setCursor(r + 3, 15);
        c.print(computerArray1a[3]);

        c.setCursor(r + 4, 15);
        c.print(computerArray1a[4]);

        c.setCursor(r + 5, 15);
        c.print(computerArray1a[5]);
    }

    public static char sequenceThree() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** sequenceThree
         * Description: This method draws the third message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "We are now down the cliff and continuing through the lush jungle. Wow! A strange creature just bursted out ofthe bushes on our left. It moved too fast for Mikayla to get a picture of it. But wait... it left footprints.I don't recognize them, but I do recognize this soil. It's very moist and it only exists near a large body ofwater. What should we do: continue in the jungle or follow the soil to the water?";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        //declares a string that will hold the user's answer
        String userAnswer;

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 218:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[1]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 327:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[2]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 408:
                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerFourFinal(45, blank, computerArray1a);
                    break;
            }

        }

        //boolean value if the user's answer is valid
        boolean valid = true;

        //boolean value if the user has sampled the soil
        boolean soilSampled = false;

        //integer value for number of valid answers the user has entered
        int validAnswerCount = 0;

        //array containing all previous valid answers from the user
        String validAnswers[] = {"", ""};

        //array containing all previous valid respones from the computer
        String validResponses[] = {"", ""};

        //y coordinate of the text to be used in the loop below
        int yCoordinate = 45;

        //amount of times the user fails to enter one of the options
        int failCount = 0;

        //array containing all previous invalid answers from the user
        String invalidAnswers[] = {"", "", ""};

        //string that will contain the user's response
        String response;

        //string that will contain the user's pathway choice, and return it
        char pathway = 'X';

        //do-while loop for the user's answer
        do{

            //resets the cursor back to original spot
            c.setCursor(50, 15);
            c.setColor(new Color(250, 250, 250)); //white

            //reads the user's answer
            userAnswer = c.readLine();

            //draws the background again (to cover the part that gets cut off)
            drawBackground();

            //prints a blank line over the original text
            c.setCursor(50, 15);
            c.print(blank);

            //if the user's answer is to sample the soil and the sample has not already been collected
            if(userAnswer.contains("sample") && userAnswer.contains("soil") && !soilSampled){

                samplesCollected += 1;

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //set soilSampled to true, so this cannot be entered again
                soilSampled = true;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Sample of the soil collected.";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){

                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                }

            }

            //if the user's answer is to continue into the jungle
            else if(userAnswer.contains("jungle")) {

                //set pathway to jungle
                pathway = 'J';

                //set valid to true (the loop will stop running)
                valid = true;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Continuing into the jungle...";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //set the first entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[1]);

                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }
            }

            //if the user's answer is to follow the water/soil
            else if((userAnswer.contains("water") || userAnswer.contains("soil")) && (userAnswer.contains("follow") || userAnswer.contains("go to")))  {

                //set pathway to soil
                pathway = 'S';

                //set valid to ture (the loop will stop running)
                valid = true;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Following the soil...";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){

                    //set the first entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[1]);

                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }

            }

            //if the user's answer is anything else
            else {

                //set valid to false (the loop will continue running)
                valid = false;

                //increase fail count by 1
                failCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                if(validAnswerCount == 0){

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate, blank, computerArray1a);
                }

                if(validAnswerCount == 1){

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                //switch statement depending on the fail count
                switch(failCount){
                    case 1:
                        //set the first entry in the array to the current user answer
                        invalidAnswers[0] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[0]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 2:
                        //set the second entry in the array to the current user answer
                        invalidAnswers[1] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[1]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 3:
                        //set the third entry in the array to the current user answer
                        invalidAnswers[2] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[2]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        //to make the text flash
                        for(int i = 0; i < 10; i ++){

                            //resets the cursor back to original spot
                            c.setCursor(50, 15);

                            if(i % 2 == 0){

                                c.setColor(new Color(54, 40, 239)); //dark blue
                                c.print("System Error");

                            } else {
                                c.setColor(new Color(59, 190, 247)); //background colour (light blue)
                                c.print("System Error");
                            }

                            Thread.sleep(200);
                        }

                        //set valid to true (stop the loop from running again)
                        valid = true;

                        //run the method crashed. It will end the program and start sequence three all over again
                        pathway = crashed(3);
                        break;
                }

            }

        } while (!valid); //runs the loop while valid is false

        Thread.sleep(2000);
        drawBackground();

        return pathway;
    }



    public static void computerFourFinal (int r, String blank, String computerArray1a[]){

        /** computerFourFinal
         * Description: This method draws the final form of the fourth computer message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerArray1a[] the array to print (from sequence three)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setCursor(r + 2, 15);
        c.print(blank);

        c.setCursor(r + 3, 15);
        c.print(blank);

        c.setCursor(r + 4, 15);
        c.print(blank);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints all lines of the third computer message
        c.setCursor(r, 15);
        c.print(computerArray1a[0]);

        c.setCursor(r + 1, 15);
        c.print(computerArray1a[1]);

        c.setCursor(r + 2, 15);
        c.print(computerArray1a[2]);

        c.setCursor(r + 3, 15);
        c.print(computerArray1a[3]);
    }

    public static void jungleSequence() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** jungleSequence
         * Description: This method draws the jungle message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "We are coming to the end of the jungle. Beyond us, there is a large prarie stretching as far as the eye can  see. This is the first discovery of an non-jungle ecosystem inside the Blurb... Now, we are walking through awaist-high vegetation. Hudson! Hudson just tripped and fell awkwardly on his ankle... He says it needs to be immobilized, but he can't do it himself. What do we do?";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        //declares a string that will hold the user's answer
        String userAnswer;

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 218:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[1]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 327:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[2]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 382:
                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(45, blank, computerArray1a);
                    break;
            }

        }

        //boolean value if the user's answer is valid
        boolean valid = true;

        //boolean value for if the user has asked for an inventory check
        boolean checkedInventory = false;

        //integer value for how many steps the user has completed
        int stepsCompleted = 0;

        //integer value for number of valid answers the user has entered
        int validAnswerCount = 0;

        //array containing all previous valid answers from the user
        String validAnswers[] = {"", "", "", "", ""};

        //array containing all previous valid respones from the computer
        String validResponses[] = {"", "", "", "", ""};

        //y coordinate of the text to be used in the loop below
        int yCoordinate = 45;

        //amount of times the user fails to enter one of the options
        int failCount = 0;

        //array containing all previous invalid answers from the user
        String invalidAnswers[] = {"", "", ""};

        //string that will contain the user's response
        String response;

        //do-while loop for the user's answer
        do{

            //resets the cursor back to original spot
            c.setCursor(50, 15);
            c.setColor(new Color(250, 250, 250)); //white

            //reads the user's answer
            userAnswer = c.readLine();

            //draws the background again (to cover the part that gets cut off)
            drawBackground();

            //prints a blank line over the original text
            c.setCursor(50, 15);
            c.print(blank);

            //if the user's answer is "inventory" and the inventory has not been checked already
            if(userAnswer.contains("inventory") && !checkedInventory){

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //set checkedInventory to true, so this cannot be entered again
                checkedInventory = true;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Inventory: Empty containers, flashlight, camping supplies.";

                if(stepsCompleted >= 1){
                    //string containing the computer's response
                    response = "Inventory: Empty containers, flashlight.";
                }

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //set the first entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[1]);

                }

                if(validAnswerCount == 3){

                    //set the first entry in the array to the current user answer
                    validAnswers[2] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[2] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 12, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[2]);
                }

                if(validAnswerCount == 4){

                    //set the fourth entry in the array to the current user answer
                    validAnswers[3] = userAnswer;

                    //set the fourth entry in the array to the current response
                    validResponses[3] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 16, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 11, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 9, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[2]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[3]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3,  15);
                    c.print(validResponses[3]);
                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){

                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                }

            }


            //if the user's answer is to open the camping supplies
            else if(userAnswer.contains("camping supplies") && stepsCompleted == 0)  {

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                //string containing the computer's response
                response = "The camping supplies spill out - a tarp, some pots and pans, and a few cutting boards. What next?";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //set the first entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[1]);

                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }

                //step one is complete
                stepsCompleted = 1;
            }

            //if the user's answer is rip the tarp
            else if((userAnswer.contains("rip") || userAnswer.contains("tear")) && userAnswer.contains("tarp") && stepsCompleted == 1)  {

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                //string containing the computer's response
                response = "The tarp has been torn into thin strips. What next?";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //set the first entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[1]);

                }

                if(validAnswerCount == 3){

                    //set the third entry in the array to the current user answer
                    validAnswers[2] = userAnswer;

                    //set the third entry in the array to the current response
                    validResponses[2] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 12, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[2]);
                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }

                //step one is complete
                stepsCompleted = 2;
            }

            //if the user's answer is to tie the cutting boards to hudson's ankle
            else if(userAnswer.contains("cutting boards") && (userAnswer.contains("tie") || userAnswer.contains("attach")) && (userAnswer.contains("ankle") || userAnswer.contains("hudson")) && stepsCompleted == 2)  {

                //set valid to ture (the loop will stop running)
                valid = true;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                //string containing the computer's response
                response = "This will be sufficient. Hudson will be able to hobble along for the rest of the mission...";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //set the second entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the second entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[1]);

                }

                if(validAnswerCount == 3){

                    //set the third entry in the array to the current user answer
                    validAnswers[2] = userAnswer;

                    //set the third entry in the array to the current response
                    validResponses[2] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 12, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[2]);
                }

                if(validAnswerCount == 4){

                    //set the fourth entry in the array to the current user answer
                    validAnswers[3] = userAnswer;

                    //set the fourth entry in the array to the current response
                    validResponses[3] = response;

                    //set the fourth entry in the array to the current user answer
                    validAnswers[3] = userAnswer;

                    //set the fourth entry in the array to the current response
                    validResponses[3] = response;

                    //calls the method for the final form of the first computer message
                    computerJungleFinal(yCoordinate - 16, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 11, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 9, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[2]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[3]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3,  15);
                    c.print(validResponses[3]);
                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }

                //step three is complete
                stepsCompleted = 3;
            }

            //if the user's answer is anything else
            else {

                //set valid to false (the loop will continue running)
                valid = false;

                //increase fail count by 1
                failCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                if(validAnswerCount == 0){

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate, blank, computerArray1a);
                }

                if(validAnswerCount == 1){

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);
                }

                if(validAnswerCount == 2){

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[1]);
                }

                if(validAnswerCount == 3){

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 12, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 7, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 5, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[1]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[2]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[2]);
                }

                //switch statement depending on the fail count
                switch(failCount){
                    case 1:
                        //set the first entry in the array to the current user answer
                        invalidAnswers[0] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[0]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 2:
                        //set the second entry in the array to the current user answer
                        invalidAnswers[1] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[1]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 3:
                        //set the third entry in the array to the current user answer
                        invalidAnswers[2] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[2]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        //to make the text flash
                        for(int i = 0; i < 10; i ++){

                            //resets the cursor back to original spot
                            c.setCursor(50, 15);

                            if(i % 2 == 0){

                                c.setColor(new Color(54, 40, 239)); //dark blue
                                c.print("System Error");

                            } else {
                                c.setColor(new Color(59, 190, 247)); //background colour (light blue)
                                c.print("System Error");
                            }

                            Thread.sleep(200);
                        }

                        //set valid to true (stop the loop from running again)
                        valid = true;

                        //run the method crashed. It will end the program and start jungle sequence all over again
                        crashed(4);
                        break;
                }

            }

        } while (!valid); //runs the loop while valid is false

        Thread.sleep(2000);
        drawBackground();
    }

    public static void computerJungleFinal (int r, String blank, String computerArray1a[]){

        /** computerJungleFinal
         * Description: This method draws the final form of the jungle pathway computer message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerArray1a[] the array to print (from jungle sequence)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setCursor(r + 2, 15);
        c.print(blank);

        c.setCursor(r + 3, 15);
        c.print(blank);

        c.setCursor(r + 4, 15);
        c.print(blank);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints all lines of the third computer message
        c.setCursor(r, 15);
        c.print(computerArray1a[0]);

        c.setCursor(r + 1, 15);
        c.print(computerArray1a[1]);

        c.setCursor(r + 2, 15);
        c.print(computerArray1a[2]);

        c.setCursor(r + 3, 15);
        c.print(computerArray1a[3]);
    }

    public static char waterSequence() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** waterSequenec
         * Description: This method draws the water message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "We have exited the jungle. Wow! In front of us sits a pristine freshwater lake. Silky black sand lies on the shore closest to us. The opposite shore is too far to see and it looks far too deep to swim across, especial-ly with all our gear. On the right, the shoreline leads towards the mouth of a cave set into a nearby rockfa-ce. On the left, the black sand and shore stretch as far as the eye can see. Which way should we go?";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        //declares a string that will hold the user's answer
        String userAnswer;

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);


        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 218:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[1]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 327:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[2]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 427:
                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerFourFinal(45, blank, computerArray1a);
                    break;
            }

        }

        //boolean value if the user's answer is valid
        boolean valid = true;

        //boolean value if the user has sampled the sand
        boolean sandSampled = false;

        //integer value for number of valid answers the user has entered
        int validAnswerCount = 0;

        //array containing all previous valid answers from the user
        String validAnswers[] = {"", ""};

        //array containing all previous valid respones from the computer
        String validResponses[] = {"", ""};

        //y coordinate of the text to be used in the loop below
        int yCoordinate = 45;

        //amount of times the user fails to enter one of the options
        int failCount = 0;

        //array containing all previous invalid answers from the user
        String invalidAnswers[] = {"", "", ""};

        //string that will contain the user's response
        String response;

        //string that will contain the user's pathway choice, and return it
        char pathway = 'X';

        //do-while loop for the user's answer
        do{

            //resets the cursor back to original spot
            c.setCursor(50, 15);
            c.setColor(new Color(250, 250, 250)); //white

            //reads the user's answer
            userAnswer = c.readLine();

            //draws the background again (to cover the part that gets cut off)
            drawBackground();

            //prints a blank line over the original text
            c.setCursor(50, 15);
            c.print(blank);

            //if the user's answer is to sample the sand and the sample has not already been collected
            if(userAnswer.contains("sample") && userAnswer.contains("sand") && !sandSampled){

                samplesCollected += 1;

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //set sandSampled to true, so this cannot be entered again
                sandSampled = true;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Sample of the sand collected.";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){

                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                }

            }

            //if the user's answer is to continue into the jungle
            else if(userAnswer.contains("cave")) {

                //set pathway to cave
                pathway = 'C';

                //set valid to true (the loop will stop running)
                valid = true;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Going into the cave...";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){
                    //set the first entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[1]);

                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }
            }

            //if the user's answer is to follow the water/soil
            else if(userAnswer.contains("lake"))  {

                //set pathway to lake
                pathway = 'L';

                //set valid to ture (the loop will stop running)
                valid = true;

                //increase validAnswers by 1, to keep track
                validAnswerCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Continuing to the left along the lakeshore...";

                if(validAnswerCount == 1){
                    //set the first entry in the array to the current user answer
                    validAnswers[0] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[0] = response;

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                if(validAnswerCount == 2){

                    //set the first entry in the array to the current user answer
                    validAnswers[1] = userAnswer;

                    //set the first entry in the array to the current response
                    validResponses[1] = response;

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 8, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate - 3, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate - 1, 15);
                    c.print(validResponses[0]);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[1]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[1]);

                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }

            }

            //if the user's answer is anything else
            else {

                //set valid to false (the loop will continue running)
                valid = false;

                //increase fail count by 1
                failCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 4, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 5, 15);
                c.print(blank);

                if(validAnswerCount == 0){

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate, blank, computerArray1a);
                }

                if(validAnswerCount == 1){

                    //calls the method for the final form of the first computer message
                    computerFourFinal(yCoordinate - 4, blank, computerArray1a);

                    c.setColor(new Color(250, 250, 250)); //white
                    c.setCursor(yCoordinate + 1, 15);
                    c.print(validAnswers[0]);

                    c.setColor(new Color(54, 40, 239)); //dark blue
                    c.setCursor(yCoordinate + 3, 15);
                    c.print(validResponses[0]);

                }

                //switch statement depending on the fail count
                switch(failCount){
                    case 1:
                        //set the first entry in the array to the current user answer
                        invalidAnswers[0] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[0]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 2:
                        //set the second entry in the array to the current user answer
                        invalidAnswers[1] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[1]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 3:
                        //set the third entry in the array to the current user answer
                        invalidAnswers[2] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[2]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        //to make the text flash
                        for(int i = 0; i < 10; i ++){

                            //resets the cursor back to original spot
                            c.setCursor(50, 15);

                            if(i % 2 == 0){

                                c.setColor(new Color(54, 40, 239)); //dark blue
                                c.print("System Error");

                            } else {
                                c.setColor(new Color(59, 190, 247)); //background colour (light blue)
                                c.print("System Error");
                            }

                            Thread.sleep(200);
                        }

                        //set valid to true (stop the loop from running again)
                        valid = true;

                        //run the method crashed. It will end the program and start the water sequence
                        pathway = crashed(6);
                        break;
                }

            }

        } while (!valid); //runs the loop while valid is false

        Thread.sleep(2000);
        drawBackground();

        return pathway;
    }

    public static void desertSequence() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** desertSequence
         * Description: This method draws the desert message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "We have been walking in the prairie for hours, but it looks like the tall vegetation is starting to fade away... It's now a desert, flat, dry, and scorching hot... We have been in this desert for days, and food and wa-ter are running low. We may have to evac the mission soon if we don't find something of interest. We haven't seen anything but sand since we entered the desert. Wait! Akari has just noticed something strange not too f-ar ahead. It's a plant! She says it is unlike anything she has ever seen before. It is about two metres high,purple with thorny pink leaves sprouting from its stem. Maybe there is something else around here... Good ne-ws! Akari has just found another plant of the same variety. In the distance there is what looks like an oasi-s. A huge stone statue stands in front of it. The inscription on it reads as follows:";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        //second message from the computer (no @ signs)
        String computerMessageTwo = "To unlock the full potential of the oasisTake what you would cal Mr. Da Vinci on a first name basisAdd to that the average for a holeThen the fourth letter and shout from your soul";

        //splits the message into individual characters
        String computerArray2[] = computerMessageTwo.split("");

        //second message from the computer (with @ signs to split)
        String computerMessageTwoSplit = "To unlock the full potential of the oasis@Take what you would cal Mr. Da Vinci on a first name basis@Add to that the average for a hole@Then the fourth letter and shout from your soul";

        //splits the message into strings of 109 characters
        String computerArray2a[] = computerMessageTwoSplit.split("@");

        //third message from the computer
        String computerMessageThree = "What should we shout?";

        //splits the message into individual characters
        String computerArray3[] = computerMessageThree.split("");

        //declares a string that will hold the user's answer
        String userAnswer;

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 218:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[1]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 327:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[2]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 436:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(46, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[2]);

                    //prints the fourth line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[3]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 545:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(45, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(46, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[2]);

                    //prints the fourth line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[3]);

                    //prints the fifth line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[4]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 654:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(44, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(45, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(46, 15);
                    c.print(computerArray1a[2]);

                    //prints the fourth line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[3]);

                    //prints the fifth line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[4]);

                    //prints the sixth line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[5]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 763:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(43, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(44, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(45, 15);
                    c.print(computerArray1a[2]);

                    //prints the fourth line one line higher than it was before
                    c.setCursor(46, 15);
                    c.print(computerArray1a[3]);

                    //prints the fifth line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[4]);

                    //prints the sixth line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[5]);

                    //prints the seventh line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[6]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 848:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //calls the method for the final form of the computer desert message
                    computerDesertFinal(41, blank, computerArray1a);

                    //resets the cursor back to original spot + 10 (x)
                    c.setCursor(50, 25);
            }

        }

        //prints the second computer message one character at a time
        for(int i = 0; i < computerArray2.length; i ++){

            //the print statement
            c.print(computerArray2[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 41:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //calls the method for the final form of the computer desert message
                    computerDesertFinal(40, blank, computerArray1a);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 25);
                    c.print(computerArray2a[0]);

                    //resets the cursor back to original spot + 10 (x)
                    c.setCursor(50, 25);
                    break;

                case 99:
                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    c.setCursor(48, 15);
                    c.print(blank);

                    //calls the method for the final form of the computer desert message
                    computerDesertFinal(39, blank, computerArray1a);

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 25);
                    c.print(computerArray2a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 25);
                    c.print(computerArray2a[1]);

                    //resets the cursor back to original spot + 10 (x)
                    c.setCursor(50, 25);
                    break;

                case 133:
                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    c.setCursor(48, 15);
                    c.print(blank);

                    //calls the method for the final form of the computer desert message
                    computerDesertFinal(38, blank, computerArray1a);

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 25);
                    c.print(computerArray2a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 25);
                    c.print(computerArray2a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 25);
                    c.print(computerArray2a[2]);

                    //resets the cursor back to original spot + 10 (x)
                    c.setCursor(50, 25);
                    break;

                case 180:
                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    c.setCursor(48, 15);
                    c.print(blank);

                    c.setCursor(43, 15);
                    c.print(blank);

                    c.setCursor(44, 15);
                    c.print(blank);

                    c.setCursor(45, 15);
                    c.print(blank);

                    //calls the method for the final form of the computer desert message
                    computerDesertFinal(36, blank, computerArray1a);

                    //calls the method for the final form of the statue inscription
                    statueFinal(45, blank, computerArray2a);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
            }

        }

        //prints the third computer message one character at a time
        for(int i = 0; i < computerArray3.length; i ++){

            //the print statement
            c.print(computerArray3[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

        }

        //prints blank lines over the original text
        c.setCursor(50, 15);
        c.print(blank);

        c.setCursor(48, 15);
        c.print(blank);

        c.setCursor(46, 15);
        c.print(blank);

        c.setCursor(45, 15);
        c.print(blank);

        c.setCursor(44, 15);
        c.print(blank);

        c.setCursor(43, 15);
        c.print(blank);

        c.setCursor(42, 15);
        c.print(blank);

        //calls the method for the final form of the computer desert message
        computerDesertFinal(34, blank, computerArray1a);

        //calls the method for the final form of the statue message
        statueFinal(43, blank, computerArray2a);

        //calls the method for the final form of the second computer desert message
        computerDesertFinal2(48, blank, computerMessageThree);

        //resets the cursor back to original spot
        c.setCursor(50, 15);

        //boolean value if the user's answer is valid
        boolean valid = true;

        //y coordinate of the text to be used in the loop below
        int yCoordinate = 34;

        //amount of times the user fails to enter one of the options
        int failCount = 0;

        //array containing all previous invalid answers from the user
        String invalidAnswers[] = {"", "", ""};

        //string that will contain the user's response
        String response;

        //do-while loop for the user's answer
        do{

            //resets the cursor back to original spot
            c.setCursor(50, 15);
            c.setColor(new Color(250, 250, 250)); //white

            //reads the user's answer
            userAnswer = c.readLine();

            //draws the background again (to cover the part that gets cut off)
            drawBackground();

            //prints a blank line over the original text
            c.setCursor(50, 15);
            c.print(blank);

            //if the user's answer is to sample the soil and the sample has not already been collected
            if(userAnswer.equalsIgnoreCase("Leopard")){

                //set valid to true (the loop will stop running)
                valid = true;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 8, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 9, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 10, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 11, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Something is happening!";

                //calls the method for the final form of the computer desert message
                computerDesertFinal(yCoordinate - 4, blank, computerArray1a);

                //calls the method for the final form of the statue message
                statueFinal(yCoordinate + 5, blank, computerArray2a);

                //calls the method for the final form of the second computer desert message
                computerDesertFinal2(yCoordinate + 10, blank, computerMessageThree);

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){

                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                }

            }

            //if the user's answer is anything else
            else {

                //set valid to false (the loop will continue running)
                valid = false;

                //increase fail count by 1
                failCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 8, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 9, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 10, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 11, 15);
                c.print(blank);

                //calls the method for the final form of the computer desert message
                computerDesertFinal(yCoordinate, blank, computerArray1a);

                //calls the method for the final form of the statue message
                statueFinal(yCoordinate + 9, blank, computerArray2a);

                //calls the method for the final form of the second computer desert message
                computerDesertFinal2(yCoordinate + 14, blank, computerMessageThree);

                //switch statement depending on the fail count
                switch(failCount){
                    case 1:
                        //set the first entry in the array to the current user answer
                        invalidAnswers[0] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[0]);

                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print(" is not the right answer");

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 2:
                        //set the second entry in the array to the current user answer
                        invalidAnswers[1] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[1]);

                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print(" is not the right answer");

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 3:
                        //set the third entry in the array to the current user answer
                        invalidAnswers[2] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[2]);

                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print(" is not the right answer");

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        //to make the text flash
                        for(int i = 0; i < 10; i ++){

                            //resets the cursor back to original spot
                            c.setCursor(50, 15);

                            if(i % 2 == 0){

                                c.setColor(new Color(54, 40, 239)); //dark blue
                                c.print("System Error");

                            } else {
                                c.setColor(new Color(59, 190, 247)); //background colour (light blue)
                                c.print("System Error");
                            }

                            Thread.sleep(200);
                        }

                        //set valid to true (stop the loop from running again)
                        valid = true;

                        //run the method crashed. It will end the program and start the desert sequence all over again
                        crashed(5);
                        break;
                }

            }

        } while (!valid); //runs the loop while valid is false

        Thread.sleep(2000);
        drawBackground();
    }

    public static void computerDesertFinal (int r, String blank, String computerArray1a[]){

        /** computerDesertFinal
         * Description: This method draws the final form of the desert computer message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerArray1a[] the array to print (from desert sequence)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setCursor(r + 2, 15);
        c.print(blank);

        c.setCursor(r + 3, 15);
        c.print(blank);

        c.setCursor(r + 4, 15);
        c.print(blank);

        c.setCursor(r + 5, 15);
        c.print(blank);

        c.setCursor(r + 6, 15);
        c.print(blank);

        c.setCursor(r + 7, 15);
        c.print(blank);

        c.setCursor(r + 8, 15);
        c.print(blank);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints all lines of the desert computer message
        c.setCursor(r, 15);
        c.print(computerArray1a[0]);

        c.setCursor(r + 1, 15);
        c.print(computerArray1a[1]);

        c.setCursor(r + 2, 15);
        c.print(computerArray1a[2]);

        c.setCursor(r + 3, 15);
        c.print(computerArray1a[3]);

        c.setCursor(r + 4, 15);
        c.print(computerArray1a[4]);

        c.setCursor(r + 5, 15);
        c.print(computerArray1a[5]);

        c.setCursor(r + 6, 15);
        c.print(computerArray1a[6]);

        c.setCursor(r + 7, 15);
        c.print(computerArray1a[7]);
    }

    public static void statueFinal (int r, String blank, String computerArray2a[]){

        /** computerDesertFinal
         * Description: This method draws the final form of the statue inscription
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerArray2a[] the array to print (from desert sequence)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setCursor(r + 2, 15);
        c.print(blank);

        c.setCursor(r + 3, 15);
        c.print(blank);

        c.setCursor(r + 4, 15);
        c.print(blank);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints all lines of the statue inscription
        c.setCursor(r, 25);
        c.print(computerArray2a[0]);

        c.setCursor(r + 1, 25);
        c.print(computerArray2a[1]);

        c.setCursor(r + 2, 25);
        c.print(computerArray2a[2]);

        c.setCursor(r + 3, 25);
        c.print(computerArray2a[3]);
    }

    public static void computerDesertFinal2 (int r, String blank, String computerMessageThree){

        /** computerDesertFinal2
         * Description: This method draws the final form of the second desert computer message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerMessageThree the string to print (from desert sequence)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints all lines of the desert computer message
        c.setCursor(r, 15);
        c.print(computerMessageThree);
    }

    public static void oasisSequence() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** oasisSequence
         * Description: This method draws the oasis message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "The entire desert is changing! It has become a gorgeous oasis! We did it! We can start the new human city ri-ght here!";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
            }

        }
        Thread.sleep(2000);
        winSequence("Adventurous");
    }

    public static void lakeSequence() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** lakeSequence
         * Description: This method draws the lake message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "We have continued following the shores of the black sand lake... Uh oh, our GPS has just broken down. We needit to navigate and map all the new areas of the Blurb that we encounter. Mikayla has opened the back and she tells me there are five wires inside, labeled Alpha, Beta, Gamma, Delta, and Epsilon. There are five nodes t-hat need to be connected, numbered 1 through 5. The manual says:";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //second message from the computer (no @ signs)
        String computerMessageTwo = "1. Alpha and Delta are connected to bordering nodes2. The wire connected to node 5 is either Gamma or Epsilon3. Beta is connected to node 34. Wires that start with vowels can't be connected to outside nodes (1 and 5)";

        //splits the message into individual characters
        String computerArray2[] = computerMessageTwo.split("");

        //second message from the computer (with @ signs to split)
        String computerMessageTwoSplit = "1. Alpha and Delta are connected to bordering nodes@2. The wire connected to node 5 is either Gamma or Epsilon@3. Beta is connected to node 3@4. Wires that start with vowels can't be connected to outside nodes (1 and 5)";

        //splits the message into strings of 109 characters
        String computerArray2a[] = computerMessageTwoSplit.split("@");

        //third message from the computer
        String computerMessageThree = "What is the correct arrangement (enter the node number follow by the capital first letter of the wire)";

        //splits the message into individual characters
        String computerArray3[] = computerMessageThree.split("");


        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        //declares a string that will hold the user's answer
        String userAnswer;

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 218:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[1]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 327:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[2]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 391:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //calls the method for the final form of the computer desert message
                    computerFourFinal(45, blank, computerArray1a);

                    //resets the cursor back to original spot + 10 (x)
                    c.setCursor(50, 25);
            }

        }

        //prints the second computer message one character at a time
        for(int i = 0; i < computerArray2.length; i ++){

            //the print statement
            c.print(computerArray2[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 51:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //calls the method for the final form of the computer desert message
                    computerFourFinal(44, blank, computerArray1a);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 25);
                    c.print(computerArray2a[0]);

                    //resets the cursor back to original spot + 10 (x)
                    c.setCursor(50, 25);
                    break;

                case 109:
                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    c.setCursor(48, 15);
                    c.print(blank);

                    //calls the method for the final form of the computer desert message
                    computerFourFinal(43, blank, computerArray1a);

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 25);
                    c.print(computerArray2a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 25);
                    c.print(computerArray2a[1]);

                    //resets the cursor back to original spot + 10 (x)
                    c.setCursor(50, 25);
                    break;

                case 139:
                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    c.setCursor(48, 15);
                    c.print(blank);

                    //calls the method for the final form of the computer desert message
                    computerFourFinal(42, blank, computerArray1a);

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 25);
                    c.print(computerArray2a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 25);
                    c.print(computerArray2a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 25);
                    c.print(computerArray2a[2]);

                    //resets the cursor back to original spot + 10 (x)
                    c.setCursor(50, 25);
                    break;

                case 216:
                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    c.setCursor(48, 15);
                    c.print(blank);

                    c.setCursor(47, 15);
                    c.print(blank);

                    c.setCursor(46, 15);
                    c.print(blank);

                    c.setCursor(43, 15);
                    c.print(blank);

                    c.setCursor(44, 15);
                    c.print(blank);

                    c.setCursor(45, 15);
                    c.print(blank);

                    //calls the method for the final form of the computer lake message
                    computerFourFinal(40, blank, computerArray1a);

                    //calls the method for the final form of the manual of the wires (statue can be used becuase it is the same formatting)
                    statueFinal(45, blank, computerArray2a);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
            }

        }

        //prints the third computer message one character at a time
        for(int i = 0; i < computerArray3.length; i ++){

            //the print statement
            c.print(computerArray3[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

        }

        //prints blank lines over the original text
        c.setCursor(50, 15);
        c.print(blank);

        c.setCursor(49, 15);
        c.print(blank);

        c.setCursor(48, 15);
        c.print(blank);

        c.setCursor(47, 15);
        c.print(blank);

        c.setCursor(46, 15);
        c.print(blank);

        c.setCursor(43, 15);
        c.print(blank);

        c.setCursor(44, 15);
        c.print(blank);

        c.setCursor(45, 15);
        c.print(blank);

        //calls the method for the final form of the computer lake message
        computerFourFinal(38, blank, computerArray1a);

        //calls the method for the final form of the manual of the wires (statue can be used becuase it is the same formatting)
        statueFinal(43, blank, computerArray2a);

        //calls the method for the final form of the second computer lake message (desert can be used again because it is the same formatting)
        computerDesertFinal2(48, blank, computerMessageThree);

        //resets the cursor back to original spot
        c.setCursor(50, 15);

        //boolean value if the user's answer is valid
        boolean valid = true;

        //y coordinate of the text to be used in the loop below
        int yCoordinate = 38;

        //amount of times the user fails to enter one of the options
        int failCount = 0;

        //array containing all previous invalid answers from the user
        String invalidAnswers[] = {"", "", ""};

        //string that will contain the user's response
        String response;

        //do-while loop for the user's answer
        do{

            //resets the cursor back to original spot
            c.setCursor(50, 15);
            c.setColor(new Color(250, 250, 250)); //white

            //reads the user's answer
            userAnswer = c.readLine();

            //draws the background again (to cover the part that gets cut off)
            drawBackground();

            //prints a blank line over the original text
            c.setCursor(50, 15);
            c.print(blank);

            //if the user's answer is to sample the soil and the sample has not already been collected
            if(userAnswer.contains("1D") && userAnswer.contains("2A") && userAnswer.contains("3B") && userAnswer.contains("4E") && userAnswer.contains("5G")){

                //set valid to true (the loop will stop running)
                valid = true;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 8, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 9, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 10, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 11, 15);
                c.print(blank);

                //calls the method for the final form of the computer lake message
                computerFourFinal(yCoordinate - 4, blank, computerArray1a);

                //calls the method for the final form of the manual of the wires (statue can be used becuase it is the same formatting)
                statueFinal(yCoordinate + 1, blank, computerArray2a);

                //calls the method for the final form of the second computer lake message (desert can be used again because it is the same formatting)
                computerDesertFinal2(yCoordinate + 6, blank, computerMessageThree);

                //string containing the computer's response
                response = "We fixed the GPS!";

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){

                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                }

            }

            //if the user's answer is anything else
            else {

                //set valid to false (the loop will continue running)
                valid = false;

                //increase fail count by 1
                failCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 8, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 9, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 10, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 11, 15);
                c.print(blank);

                //calls the method for the final form of the computer lake message
                computerFourFinal(yCoordinate, blank, computerArray1a);

                //calls the method for the final form of the manual of the wires (statue can be used becuase it is the same formatting)
                statueFinal(yCoordinate + 5, blank, computerArray2a);

                //calls the method for the final form of the second computer lake message (desert can be used again because it is the same formatting)
                computerDesertFinal2(yCoordinate + 10, blank, computerMessageThree);

                //switch statement depending on the fail count
                switch(failCount){
                    case 1:
                        //set the first entry in the array to the current user answer
                        invalidAnswers[0] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[0]);

                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print(" is not the correct arrangement of wires");

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 2:
                        //set the second entry in the array to the current user answer
                        invalidAnswers[1] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[1]);

                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print(" is not the correct arrangement of wires");

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 3:
                        //set the third entry in the array to the current user answer
                        invalidAnswers[2] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[2]);

                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print(" is not the correct arrangement of wires");

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        //to make the text flash
                        for(int i = 0; i < 10; i ++){

                            //resets the cursor back to original spot
                            c.setCursor(50, 15);

                            if(i % 2 == 0){

                                c.setColor(new Color(54, 40, 239)); //dark blue
                                c.print("System Error");

                            } else {
                                c.setColor(new Color(59, 190, 247)); //background colour (light blue)
                                c.print("System Error");
                            }

                            Thread.sleep(200);
                        }

                        //set valid to true (stop the loop from running again)
                        valid = true;

                        //run the method crashed. It will end the program and start the desert sequence all over again
                        crashed(7);
                        break;
                }

            }

        } while (!valid); //runs the loop while valid is false

        Thread.sleep(2000);
        drawBackground();
    }

    public static char alienSequence() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** alienSequence
         * Description: This method draws the alien message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         **/

        //first message from the computer
        String computerMessageOne = "OH MY... In front of us there is a towering complex of buildings stretching across the horizon. They are tallbut appear to have no windows or doors. A hovercar from the complex is flying towards us. Seven tall beings  jump down from the car, each about 4 metres tall. They have bright blue skin, and six limbs, but other than  that, appear humanoid. Mikayla is furiously snapping pictures. The one in the middle is speaking! They say:  \"Greetings humans, we have been expecting your arrival for six hundred years. What took you so long?\" The ot-her beings laugh at this. \"Come with us, we have much to show you.\" I have just been informed that we have t-he military standing by outside the Blurb. It's your choice: engage in war, or follow the aliens?";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        //declares a string that will hold the user's answer
        String userAnswer;

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 218:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[1]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 327:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[2]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 436:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(46, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[2]);

                    //prints the fourth line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[3]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 545:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(45, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(46, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[2]);

                    //prints the fourth line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[3]);

                    //prints the fifth line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[4]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 654:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(44, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(45, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(46, 15);
                    c.print(computerArray1a[2]);

                    //prints the fourth line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[3]);

                    //prints the fifth line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[4]);

                    //prints the sixth line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[5]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 751:
                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerAlienFinal(42, blank, computerArray1a);
                    break;

            }

        }

        //boolean value if the user's answer is valid
        boolean valid = true;

        //y coordinate of the text to be used in the loop below
        int yCoordinate = 42;

        //amount of times the user fails to enter one of the options
        int failCount = 0;

        //array containing all previous invalid answers from the user
        String invalidAnswers[] = {"", "", ""};

        //string that will contain the user's response
        String response;

        //string that will contain the user's pathway choice, and return it
        char pathway = 'X';

        //do-while loop for the user's answer
        do{

            //resets the cursor back to original spot
            c.setCursor(50, 15);
            c.setColor(new Color(250, 250, 250)); //white

            //reads the user's answer
            userAnswer = c.readLine();

            //draws the background again (to cover the part that gets cut off)
            drawBackground();

            //prints a blank line over the original text
            c.setCursor(50, 15);
            c.print(blank);

            //if the user's answer is to fight the aliens
            if(userAnswer.contains("war")) {

                //set valid to true (the loop will stop running)
                valid = true;

                //set pathway to war
                pathway = 'W';

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 8, 15);
                c.print(blank);

                //calls the method for the final form of the first computer message
                computerAlienFinal(yCoordinate - 4, blank, computerArray1a);

                //string containing the computer's response
                response = "Informing the military of your decision now...";

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }
            }

            //if the user's answer is to follow the aliens
            else if(userAnswer.contains("follow") && userAnswer.contains("aliens"))  {

                //set pathway to peace
                pathway = 'P';

                //set valid to true (the loop will stop running)
                valid = true;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 8, 15);
                c.print(blank);

                //calls the method for the final form of the first computer message
                computerAlienFinal(yCoordinate - 4, blank, computerArray1a);

                //string containing the computer's response
                response = "Following the aliens...";

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //prints the user's answer
                c.setCursor(46, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);
                }

            }

            //if the user's answer is anything else
            else {

                //set valid to false (the loop will continue running)
                valid = false;

                //increase fail count by 1
                failCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 8, 15);
                c.print(blank);

                //calls the method for the final form of the first computer message
                computerAlienFinal(yCoordinate, blank, computerArray1a);

                //switch statement depending on the fail count
                switch(failCount){
                    case 1:
                        //set the first entry in the array to the current user answer
                        invalidAnswers[0] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[0]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 2:
                        //set the second entry in the array to the current user answer
                        invalidAnswers[1] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[1]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 3:
                        //set the third entry in the array to the current user answer
                        invalidAnswers[2] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[2]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        //to make the text flash
                        for(int i = 0; i < 10; i ++){

                            //resets the cursor back to original spot
                            c.setCursor(50, 15);

                            if(i % 2 == 0){

                                c.setColor(new Color(54, 40, 239)); //dark blue
                                c.print("System Error");

                            } else {
                                c.setColor(new Color(59, 190, 247)); //background colour (light blue)
                                c.print("System Error");
                            }

                            Thread.sleep(200);
                        }

                        //set valid to true (stop the loop from running again)
                        valid = true;

                        //run the method crashed. It will end the program and start the alien sequence again
                        pathway = crashed(8);
                        break;
                }

            }

        } while (!valid); //runs the loop while valid is false

        Thread.sleep(2000);
        drawBackground();

        return pathway;
    }

    public static void computerAlienFinal (int r, String blank, String computerArray1a[]){

        /** computerAlienFinal
         * Description: This method draws the final form of the alien computer message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerArray1a[] the array to print (from alien sequence)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setCursor(r + 2, 15);
        c.print(blank);

        c.setCursor(r + 3, 15);
        c.print(blank);

        c.setCursor(r + 4, 15);
        c.print(blank);

        c.setCursor(r + 5, 15);
        c.print(blank);

        c.setCursor(r + 6, 15);
        c.print(blank);

        c.setCursor(r + 7, 15);
        c.print(blank);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints all lines of the desert computer message
        c.setCursor(r, 15);
        c.print(computerArray1a[0]);

        c.setCursor(r + 1, 15);
        c.print(computerArray1a[1]);

        c.setCursor(r + 2, 15);
        c.print(computerArray1a[2]);

        c.setCursor(r + 3, 15);
        c.print(computerArray1a[3]);

        c.setCursor(r + 4, 15);
        c.print(computerArray1a[4]);

        c.setCursor(r + 5, 15);
        c.print(computerArray1a[5]);

        c.setCursor(r + 6, 15);
        c.print(computerArray1a[6]);
    }

    public static void warSequence() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** warSequence
         * Description: This method draws the war message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "After a long and bloody war, with heavy losses on both sides, we have emerged victorious. The aliens have su-rrendered half of their city to us to establish our new human city. We have saved the population, but it com-es at a great cost. The citizens of the new city will live in constant fear of a technologically advanced al-ien civilization living just over the wall.";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 218:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[1]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 327:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[2]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
            }

        }
        Thread.sleep(2000);
        winSequence("Bloodthirsty");
    }

    public static void peaceSequence() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** peaceSequence
         * Description: This method draws the peace message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "We followed the aliens into the city... Turns out the one talking to us was actually their prime minister, Q-aratira. She told us that they evolved naturally on this planet and that they have been keeping an eye on us ever since we landed here over six hundred years ago. After discussions led by Mikayla, they have agreed to  help us build a neighbouring city along the shores of the lake. We will live in harmony, sharing technologiesdiscoveries, and innovations with each other. We've done it! The people of Foramor are saved!";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 218:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[1]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 327:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //prints the first line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[2]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
                case 436:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //prints the first line one line higher than it was before
                    c.setCursor(46, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(47, 15);
                    c.print(computerArray1a[1]);

                    //prints the third line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[2]);

                    //prints the fourth line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[3]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
            }

        }
        Thread.sleep(2000);
        winSequence("Peaceful");
    }

    public static void caveSequence() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** caveSequence
         * Description: This method draws the cave message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         **/

        //first message from the computer
        String computerMessageOne = "We are entering the cave. There are three pathways. The left slopes upwards, the middle slopes downwards, andthe right is straight ahead. Which pathway should we take, 1, 2, or 3?";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        //declares a string that will hold the user's answer
        String userAnswer;

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:

                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 179:

                    //prints blank lines over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setCursor(49, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerCaveFinal(47, blank, computerArray1a);
                    break;
            }

        }

        boolean sapSampled = false;

        //boolean value if the user's answer is valid
        boolean valid = true;

        //integer value for what tunnel the user is in
        int currentTunnel = 0;

        //integer value for how many steps the user has completed
        int stepsCompleted = 0;

        //y coordinate of the text to be used in the loop below
        int yCoordinate = 47;

        //amount of times the user fails to enter one of the options
        int failCount = 0;

        //array containing all previous invalid answers from the user
        String invalidAnswers[] = {"", "", ""};

        //string that will contain the user's response
        String response;

        //do-while loop for the user's answer
        do{

            //resets the cursor back to original spot
            c.setCursor(50, 15);
            c.setColor(new Color(250, 250, 250)); //white

            //reads the user's answer
            userAnswer = c.readLine();

            //draws the background again (to cover the part that gets cut off)
            drawBackground();

            //prints a blank line over the original text
            c.setCursor(50, 15);
            c.print(blank);

            //if the user's answer is 1
            if(userAnswer.equals("1"))  {

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                //string containing the computer's response
                response = "";

                //if the pathway is 1
                if(currentTunnel == 0){
                    response = "First tunnel: There are three more pathways. 1, 2, or 3?";

                    currentTunnel = 1;
                }

                //if the pathway is 1 - 1
                else if(currentTunnel == 1){
                    //string containing the computer's response
                    response = "This pathway leads in a circle back to the beginning. Which way this time, 1, 2, or 3?";

                    currentTunnel = 0;
                }

                //if the pathway is 2 - 1
                else if(currentTunnel == 2){
                    response = "This tunnel dead ends. We are retracing our steps to get our bearings back. Back to the beginning. 1, 2, or 3?";

                    currentTunnel = 0;
                }

                //if the pathway is 3 - 1
                else if(currentTunnel == 3){

                    if(stepsCompleted == 0){
                        response = "There is a small wooden chest with a brass lock lying on the floor. We don't have a key to unlock it... Back to the third tunnel. 1, 2, or 3?";
                    }
                    else if (stepsCompleted == 1){
                        response = "There is a small wooden chest with a brass lock lying on the floor. We unlocked it... Inside there are two s-mall stone cubes. Back to the beginning. 1, 2, or 3?";

                        stepsCompleted = 2;
                        currentTunnel = 0;
                    }

                    else if (stepsCompleted == 2){
                        response = "There is the small wooden chest that we already unlocked. Back to the beginning. 1, 2, or 3?";
                        currentTunnel = 0;
                    }
                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //calls the method for the final form of the first computer message
                computerCaveFinal(yCoordinate - 2, blank, computerArray1a);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //splits the message into strings of 109 characters
                String responseArray1[] = response.split("(?<=\\G.{109})");


                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                    //switch to move to the next line
                    switch(i){
                        case 109:

                            //calls the method for the final form of the first computer message
                            computerCaveFinal(yCoordinate - 3, blank, computerArray1a);

                            //prints a blank line over the original text
                            c.setCursor(46, 15);
                            c.print(blank);

                            c.setCursor(47, 15);
                            c.print(blank);

                            c.setCursor(48, 15);
                            c.print(blank);

                            //prints the first line one line higher than it was before
                            c.setCursor(47, 15);
                            c.print(responseArray1[0]);

                            //resets the cursor back to original spot
                            c.setCursor(48, 15);
                            break;
                    }

                }
            }

            //if the user's answer is 2
            else if(userAnswer.equals("2"))  {

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                //string containing the computer's response
                response = "";

                //if the pathway is 2
                if(currentTunnel == 0){
                    response = "Second tunnel: There are three more pathways. 1, 2, or 3?";

                    currentTunnel = 2;
                }

                //if the pathway is 1 - 2
                else if(currentTunnel == 1){
                    //string containing the computer's response
                    response = "This pathway leads to a room with an opening to the outside, which appears blocked off. Back to the first tu-nnel. 1, 2, or 3?";
                }

                //if the pathway is 2 - 2
                else if(currentTunnel == 2){
                    response = "There is a massive cavern full of sap. Not much we can do here, but I will collect a sample. Back to the sec-ond tunnel. 1, 2, or 3?";

                    if(!sapSampled){
                        samplesCollected += 1;
                        sapSampled = true;
                    }
                }

                //if the pathway is 3 - 2
                else if(currentTunnel == 3){
                    response = "This tunnel leads to a chasm far to big to cross. We don't want to fall down this one! Back to the third tun-nel. 1, 2, or 3?";
                }


                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //calls the method for the final form of the first computer message
                computerCaveFinal(yCoordinate - 2, blank, computerArray1a);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //splits the message into strings of 109 characters
                String responseArray1[] = response.split("(?<=\\G.{109})");


                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                    //switch to move to the next line
                    switch(i){
                        case 109:

                            //calls the method for the final form of the first computer message
                            computerCaveFinal(yCoordinate - 3, blank, computerArray1a);

                            //prints a blank line over the original text
                            c.setCursor(46, 15);
                            c.print(blank);

                            c.setCursor(47, 15);
                            c.print(blank);

                            c.setCursor(48, 15);
                            c.print(blank);

                            //prints the first line one line higher than it was before
                            c.setCursor(47, 15);
                            c.print(responseArray1[0]);

                            //resets the cursor back to original spot
                            c.setCursor(48, 15);
                            break;
                    }

                }
            }

            //if the user's answer is 3
            else if(userAnswer.equals("3"))  {

                //set valid to false (the answer is valid but the loop will continue running)
                valid = false;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                //string containing the computer's response
                response = "";

                //if the pathway is 3
                if(currentTunnel == 0){
                    response = "Third tunnel: There are three more pathways. 1, 2, or 3?";

                    currentTunnel = 3;
                }

                //if the pathway is 1 - 3
                else if(currentTunnel == 1){

                    if(stepsCompleted == 0){
                        response = "The cave at the end of this path has a large hole in the ceiling. Sunlight is pouring in. The opening is cle-arly too high to reach, but there is a brass key on the floor. We picked it up and went back to the beginning1, 2, or 3?";
                        stepsCompleted = 1;
                        currentTunnel = 0;
                    }

                    else if(stepsCompleted > 0){
                        response = "This is the cave where we picked up the brass key. Back to the beginning. 1, 2, or 3?";
                        currentTunnel = 0;
                    }

                }

                //if the pathway is 2 - 3
                else if(currentTunnel == 2){

                    if(stepsCompleted < 2){
                        response = "In front of us there is a massive stone door with two small cubic holes. There's nothing else we can do here.Back to the second tunnel. 1, 2, or 3?";
                    }

                    else if(stepsCompleted == 2){
                        response = "In front of us there is a massive stone door with two small cubic holes. Hudson suggested putting the stone  cubes we picked up into the door. It's worth a shot. WOAH...";

                        stepsCompleted = 3;

                        //set valid to true (this is the only way to stop the loop)
                        valid = true;
                    }
                }

                //if the pathway is 3 - 3
                else if(currentTunnel == 3){
                    response = "The tunnel down this way is caved in... Mikayla had a small panic attack, so we went back to the beginning f-or her to get some fresh air. Ready to go again. 1, 2, or 3?";

                    currentTunnel = 0;
                }

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                //calls the method for the final form of the first computer message
                computerCaveFinal(yCoordinate - 2, blank, computerArray1a);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //splits the message into strings of 109 characters
                String responseArray1[] = response.split("(?<=\\G.{109})");


                //resets the cursor back to the original spot
                c.setCursor(48, 15);
                c.setColor(new Color(54, 40, 239)); //dark blue

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                    //switch to move to the next line
                    switch(i){
                        case 109:

                            //calls the method for the final form of the first computer message
                            computerCaveFinal(yCoordinate - 3, blank, computerArray1a);

                            //prints a blank line over the original text
                            c.setCursor(46, 15);
                            c.print(blank);

                            c.setCursor(47, 15);
                            c.print(blank);

                            c.setCursor(48, 15);
                            c.print(blank);

                            //prints the first line one line higher than it was before
                            c.setCursor(47, 15);
                            c.print(responseArray1[0]);

                            //resets the cursor back to original spot
                            c.setCursor(48, 15);
                            break;
                        case 218:

                            //calls the method for the final form of the first computer message
                            computerCaveFinal(yCoordinate - 4, blank, computerArray1a);

                            //prints a blank line over the original text
                            c.setCursor(45, 15);
                            c.print(blank);

                            c.setCursor(46, 15);
                            c.print(blank);

                            c.setCursor(47, 15);
                            c.print(blank);

                            c.setCursor(48, 15);
                            c.print(blank);

                            //prints the first line one line higher than it was before
                            c.setCursor(46, 15);
                            c.print(responseArray1[0]);

                            //prints the first line one line higher than it was before
                            c.setCursor(47, 15);
                            c.print(responseArray1[1]);

                            //resets the cursor back to original spot
                            c.setCursor(48, 15);
                            break;
                    }

                }
            }

            //if the user's answer is anything else
            else {



                //set valid to false (the loop will continue running)
                valid = false;

                //increase fail count by 1
                failCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 1, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 2, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 3, 15);
                c.print(blank);

                //calls the method for the final form of the first computer message
                computerCaveFinal(yCoordinate, blank, computerArray1a);

                //switch statement depending on the fail count
                switch(failCount){
                    case 1:
                        //set the first entry in the array to the current user answer
                        invalidAnswers[0] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[0]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 2:
                        //set the second entry in the array to the current user answer
                        invalidAnswers[1] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[1]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 3:
                        //set the third entry in the array to the current user answer
                        invalidAnswers[2] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(54, 40, 239)); //dark blue
                        c.print("I do not understand what you mean by ");
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print(invalidAnswers[2]);

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        //to make the text flash
                        for(int i = 0; i < 10; i ++){

                            //resets the cursor back to original spot
                            c.setCursor(50, 15);

                            if(i % 2 == 0){

                                c.setColor(new Color(54, 40, 239)); //dark blue
                                c.print("System Error");

                            } else {
                                c.setColor(new Color(59, 190, 247)); //background colour (light blue)
                                c.print("System Error");
                            }

                            Thread.sleep(200);
                        }

                        //set valid to true (stop the loop from running again)
                        valid = true;

                        //run the method crashed. It will end the program and start cave sequence all over again
                        crashed(9);

                        //makes sure sap is only sampled once
                        if(sapSampled){
                            samplesCollected -= 1;
                        }

                        break;
                }

            }

        } while (!valid); //runs the loop while valid is false

        Thread.sleep(2000);
        drawBackground();
    }

    public static void computerCaveFinal (int r, String blank, String computerArray1a[]){

        /** computerFourFinal
         * Description: This method draws the final form of the cave computer message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerArray1a[] the array to print (from cave sequence)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setCursor(r + 2, 15);
        c.print(blank);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints all lines of the cave computer message
        c.setCursor(r, 15);
        c.print(computerArray1a[0]);

        c.setCursor(r + 1, 15);
        c.print(computerArray1a[1]);
    }


    public static void metalSequence() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** metalSequence
         * Description: This method draws the metal message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "It's an entire cave of the rare metal ardenium! This is insane! There is definitely enough of it here to pow-er the construction of thousands of new homes in Foramor! We can save the people! I will contact my superiorsimmediately. We've done it!";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //splits the message into strings of 109 characters
        String computerArray1a[] = computerMessageOne.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        //boolean to see if hudson betrays the team (35% that he does, 65% that he doesn't)
        boolean hudsonBetrays = (Math.random() > 0.65);

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);

        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
                case 218:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //prints the first line one line higher than it was before
                    c.setCursor(48, 15);
                    c.print(computerArray1a[0]);

                    //prints the second line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray1a[1]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
            }

        }

        //if hudson doesn't betray, start a win sequence. If he does, start the takeover sequence.
        if(!hudsonBetrays){

            Thread.sleep(2000);
            winSequence("Heroic");
        }

        else if (hudsonBetrays){
            Thread.sleep(2000);
            drawBackground();
            takeoverSequence();
        }
    }

    public static void takeoverSequence() throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** caveSequence
         * Description: This method draws the takeover message sequence
         *
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //first message from the computer
        String computerMessageOne = "Hudson? Hudson! What are you doing?";

        //splits the message into individual characters
        String computerArray1[] = computerMessageOne.split("");

        //second message from the computer
        String computerMessageTwo = "This is Hudson Rain, your new boss. I have taken over this team. This cave of ardenium is worth over 50 bill-ion credits on the black market! I'll be rich!";

        //splits the message into individual characters
        String computerArray2[] = computerMessageTwo.split("");

        //splits the message into strings of 109 characters
        String computerArray2a[] = computerMessageTwo.split("(?<=\\G.{109})");

        //first message from the user
        String userMessage = "You have two options: Turn Mr. Rain into the government, or blackmail him to wire you 10 billion credits and turn a blind eye. What will you do?";

        //splits the message into individual characters
        String userArray1[] = userMessage.split("");

        //splits the message into strings of 109 characters
        String userArray1a[] = userMessage.split("(?<=\\G.{109})");

        //a blank string of 109 characters
        String blank = "                                                                                                             ";

        //declares a string that will hold the user's answer
        String userAnswer;

        c.setColor(new Color(54, 40, 239)); //dark blue
        c.setCursor(50, 15);


        //prints the first computer message one character at a time
        for(int i = 0; i < computerArray1.length; i ++){

            //the print statement
            c.print(computerArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);
        }

        //calls the method for the final form of the first computer message
        computerTakeoverFinal(48, blank, computerMessageOne);

        //prints a blank line over the original text
        c.setCursor(50, 15);
        c.print(blank);

//resets the cursor back to original spot
        c.setCursor(50, 15);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints the second computer message one character at a time
        for(int i = 0; i < computerArray2.length; i ++){

            //the print statement
            c.print(computerArray2[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerTakeoverFinal(47, blank, computerMessageOne);

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(computerArray2a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 155:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    //calls the method for the final form of the first computer message
                    computerTakeoverFinal(45, blank, computerMessageOne);

                    //calls the method for the final form of the user computer message
                    computerTakeoverFinal2(47, blank, computerArray2a);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);

            }

        }

        c.setColor(new Color(250, 250, 250)); //white

        //prints the first user message one character at a time
        for(int i = 0; i < userArray1.length; i ++){

            //the print statement
            c.print(userArray1[i]);

            //waits 5 milliseconds before printing the next character
            Thread.sleep(5);

            //switch to move to the next line
            switch(i){
                case 109:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //calls the method for the final form of the first computer message
                    computerTakeoverFinal(44, blank, computerMessageOne);

                    //calls the method for the final form of the second computer message
                    computerTakeoverFinal2(46, blank, computerArray2a);

                    c.setColor(new Color(250, 250, 250)); //white

                    //prints the first line one line higher than it was before
                    c.setCursor(49, 15);
                    c.print(userArray1a[0]);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;

                case 144:
                    //prints a blank line over the original text
                    c.setCursor(50, 15);
                    c.print(blank);

                    c.setColor(new Color(54, 40, 239)); //dark blue

                    //calls the method for the final form of the first computer message
                    computerTakeoverFinal(42, blank, computerMessageOne);

                    //calls the method for the final form of the second computer message
                    computerTakeoverFinal2(44, blank, computerArray2a);

                    c.setColor(new Color(250, 250, 250)); //white

                    //calls the method for the final form of the user message (can be used again because same formatting)
                    computerTakeoverFinal2(47, blank, userArray1a);

                    //resets the cursor back to original spot
                    c.setCursor(50, 15);
                    break;
            }
        }

        // a character to hold the user's choice
        char userChoice = 'X';

        //boolean value if the user's answer is valid
        boolean valid = true;

        //y coordinate of the text to be used in the loop below
        int yCoordinate = 42;

        //amount of times the user fails to enter one of the options
        int failCount = 0;

        //array containing all previous invalid answers from the user
        String invalidAnswers[] = {"", "", ""};

        //string that will contain the user's response
        String response;

        //do-while loop for the user's answer
        do{

            //resets the cursor back to original spot
            c.setCursor(50, 15);
            c.setColor(new Color(250, 250, 250)); //white

            //reads the user's answer
            userAnswer = c.readLine();

            //draws the background again (to cover the part that gets cut off)
            drawBackground();

            //prints a blank line over the original text
            c.setCursor(50, 15);
            c.print(blank);

            //if the user's answer is to turn in hudson
            if(userAnswer.contains("turn") && (userAnswer.contains("in Hudson") || userAnswer.contains("him in")))  {

                //set user choice to turn him in
                userChoice = 'T';

                //set valid to true (the loop will stop running)
                valid = true;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 8, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Turning in Hudson...";

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                c.setColor(new Color(54, 40, 239)); //dark blue

                //calls the method for the final form of the first computer message
                computerTakeoverFinal(yCoordinate - 2, blank, computerMessageOne);

                //calls the method for the final form of the second computer message
                computerTakeoverFinal2(yCoordinate, blank, computerArray2a);

                c.setColor(new Color(250, 250, 250)); //white

                //calls the method for the final form of the user message (can be used again because same formatting)
                computerTakeoverFinal2(yCoordinate + 3, blank, userArray1a);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //prints the user's answer
                c.setCursor(48, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //resets the cursor back to the original spot
                c.setCursor(50, 15);

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                }
            }

            //if the user's answer is to blackmail him
            else if(userAnswer.contains("blackmail"))  {

                //set user choice to blackmail
                userChoice = 'B';

                //set valid to true (the loop will stop running)
                valid = true;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 8, 15);
                c.print(blank);

                //string containing the computer's response
                response = "Sending the message...";

                //prints a blank line over the original text
                c.setCursor(48, 15);
                c.print(blank);

                c.setColor(new Color(54, 40, 239)); //dark blue

                //calls the method for the final form of the first computer message
                computerTakeoverFinal(yCoordinate - 2, blank, computerMessageOne);

                //calls the method for the final form of the second computer message
                computerTakeoverFinal2(yCoordinate, blank, computerArray2a);

                c.setColor(new Color(250, 250, 250)); //white

                //calls the method for the final form of the user message (can be used again because same formatting)
                computerTakeoverFinal2(yCoordinate + 3, blank, userArray1a);

                //splits the response into individual characters
                String responseArray[] = response.split("");

                //prints the user's answer
                c.setCursor(48, 15);
                c.setColor(new Color(250, 250, 250)); //white
                c.print(userAnswer);

                //resets the cursor back to the original spot
                c.setCursor(50, 15);

                //prints the response one character at a time
                for(int i = 0; i < responseArray.length; i ++){
                    //the print statement
                    c.print(responseArray[i]);

                    //waits 5 milliseconds before printing the next character
                    Thread.sleep(5);

                }
            }


            //if the user's answer is anything else
            else {

                c.setColor(new Color(54, 40, 239)); //dark blue

                //calls the method for the final form of the first computer message
                computerTakeoverFinal(yCoordinate, blank, computerMessageOne);

                //calls the method for the final form of the second computer message
                computerTakeoverFinal2(yCoordinate + 2, blank, computerArray2a);

                c.setColor(new Color(250, 250, 250)); //white

                //calls the method for the final form of the user message (can be used again because same formatting)
                computerTakeoverFinal2(yCoordinate + 5, blank, userArray1a);

                //set valid to false (the loop will continue running)
                valid = false;

                //increase fail count by 1
                failCount += 1;

                //prints blank lines over the original text
                c.setCursor(yCoordinate + 6, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 7, 15);
                c.print(blank);

                c.setCursor(yCoordinate + 8, 15);
                c.print(blank);

                //switch statement depending on the fail count
                switch(failCount){
                    case 1:
                        //set the first entry in the array to the current user answer
                        invalidAnswers[0] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print("\"" + invalidAnswers[0] + "\" is not a valid answer");

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 2:
                        //set the second entry in the array to the current user answer
                        invalidAnswers[1] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print("\"" + invalidAnswers[1] + "\" is not a valid answer");

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        break;
                    case 3:
                        //set the third entry in the array to the current user answer
                        invalidAnswers[2] = userAnswer;

                        //resets the cursor back to the original spot
                        c.setCursor(50, 15);

                        //prints computer response
                        c.setColor(new Color(250, 250, 250)); //white
                        c.print("\"" + invalidAnswers[2] + "\" is not a valid answer");

                        Thread.sleep(2000);

                        //prints a blank line over the original text
                        c.setCursor(50, 15);
                        c.print(blank);

                        //to make the text flash
                        for(int i = 0; i < 10; i ++){

                            //resets the cursor back to original spot
                            c.setCursor(50, 15);

                            if(i % 2 == 0){

                                c.setColor(new Color(54, 40, 239)); //dark blue
                                c.print("System Error");

                            } else {
                                c.setColor(new Color(59, 190, 247)); //background colour (light blue)
                                c.print("System Error");
                            }

                            Thread.sleep(200);
                        }

                        //set valid to true (stop the loop from running again)
                        valid = true;

                        //run the method crashed. It will end the program and start takeover sequence all over again
                        crashed(10);
                        break;
                }

            }

        } while (!valid); //runs the loop while valid is false

        Thread.sleep(2000);
        drawBackground();

        if(userChoice == 'T'){
            winSequence("Patriotic");
        }

        if(userChoice == 'B'){
            winSequence("Greedy");
        }
    }


    public static void computerTakeoverFinal (int r, String blank, String computerMessageOne){

        /** computerDesertFinal2
         * Description: This method draws the final form of the takeover computer message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerMessageOne the string to print (from takeover sequence)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setColor(new Color(54, 40, 239)); //dark blue

        //prints all lines of the desert computer message
        c.setCursor(r, 15);
        c.print(computerMessageOne);
    }

    public static void computerTakeoverFinal2 (int r, String blank, String computerArray2a[]){

        /** computerDesertFinal2
         * Description: This method draws the final form of the takeover computer message
         *
         *
         * @r the value of the row where it will be printed
         *
         * @ blank blank string
         *
         * @ computerArray1a the array to print (from takeover sequence)
         **/

        //prints blank lines over the original text
        c.setCursor(r + 1, 15);
        c.print(blank);

        c.setCursor(r + 2, 15);
        c.print(blank);

        //prints all lines of the takeover computer message
        c.setCursor(r, 15);
        c.print(computerArray2a[0]);

        c.setCursor(r + 1, 15);
        c.print(computerArray2a[1]);
    }


    public static char crashed (int option) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** messageOne
         * Description: This method is for when the user crashes the program (not actually crashes - an in game "crash")
         *
         *
         * @ option the number of the sequence to restart
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        programCrashes += 1;

        //clears the background
        c.setBackgroundColor(new Color(59, 190, 247)); //background colour (light blue)
        c.clear();

        c.setColor(new Color(54, 40, 239)); //dark blue
        Font elixia = Font.createFont(Font.TRUETYPE_FONT, FullGame.class.getResourceAsStream("ELIXIA.ttf"));
        c.setFont(elixia.deriveFont(Font.PLAIN, 100));

        //draws the message
        c.drawString("YOU LOSE", CONSOLE_WIDTH/2 - 175, CONSOLE_HEIGHT/2);

        //waits one second
        Thread.sleep(1000);

        //draws the background
        drawBackground();

        char path = 'X';

        switch (option){
            case 1:
                //restarts sequence one
                sequenceOne();
                break;
            case 2:
                //restarts sequence two
                sequenceTwo();
                break;
            case 3:
                //restarts sequence three
                path = sequenceThree();
                break;
            case 4:
                //restarts jungle sequence
                jungleSequence();
                break;
            case 5:
                //restarts desert sequence
                desertSequence();
                break;
            case 6:
                //restarts water sequence
                path = waterSequence();
                break;
            case 7:
                //restarts lake sequence
                lakeSequence();
                break;
            case 8:
                //restarts alien sequence
                path = alienSequence();
                break;
            case 9:
                //restarts cave sequence
                caveSequence();
                break;
            case 10:
                //restarts takeover sequence
                takeoverSequence();
                break;
        }
        return path;
    }

    public static void winSequence (String winType) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** messageOne
         * Description: This method is for when the user crashes the program (not actually crashes - an in game "crash")
         *
         *
         * @ winType the type of victory earned by the user
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         **/

        //clears the background
        c.setBackgroundColor(new Color(59, 190, 247)); //background colour (light blue)
        c.clear();

        c.setColor(new Color(54, 40, 239)); //dark blue
        Font elixia = Font.createFont(Font.TRUETYPE_FONT, FullGame.class.getResourceAsStream("ELIXIA.ttf"));
        c.setFont(elixia.deriveFont(Font.PLAIN, 100));

        //draws the you win message
        c.drawString("YOU WIN", CONSOLE_WIDTH/2 - 175, CONSOLE_HEIGHT/2);

        c.setFont(elixia.deriveFont(Font.PLAIN, 50));

        //draws the subtitle for way to win, depending on the win type entered

        if(winType.equals("Adventurous")){
            c.drawString("the adventurous way", CONSOLE_WIDTH/2 - 225, CONSOLE_HEIGHT/2 + 60);

            Thread.sleep(5000);

            closingCredits(CONSOLE_WIDTH, CONSOLE_HEIGHT, "Adventurous");
        }

        if(winType.equals("Heroic")){
            c.drawString("the heroic way", CONSOLE_WIDTH/2 - 172, CONSOLE_HEIGHT/2 + 60);

            Thread.sleep(5000);

            closingCredits(CONSOLE_WIDTH, CONSOLE_HEIGHT, "Heroic");
        }

        if(winType.equals("Greedy")){
            c.drawString("the greedy way", CONSOLE_WIDTH/2 - 172, CONSOLE_HEIGHT/2 + 60);

            Thread.sleep(5000);

            closingCredits(CONSOLE_WIDTH, CONSOLE_HEIGHT, "Greedy");
        }

        if(winType.equals("Patriotic")){
            c.drawString("the patriotic way", CONSOLE_WIDTH/2 - 190, CONSOLE_HEIGHT/2 + 60);

            Thread.sleep(5000);

            closingCredits(CONSOLE_WIDTH, CONSOLE_HEIGHT, "Patriotic");
        }

        if(winType.equals("Peaceful")){
            c.drawString("the peaceful way", CONSOLE_WIDTH/2 - 190, CONSOLE_HEIGHT/2 + 60);

            Thread.sleep(5000);

            closingCredits(CONSOLE_WIDTH, CONSOLE_HEIGHT, "Peaceful");
        }

        if(winType.equals("Bloodthirsty")){
            c.drawString("the bloodthirsty way", CONSOLE_WIDTH/2 - 220, CONSOLE_HEIGHT/2 + 60);

            Thread.sleep(5000);

            closingCredits(CONSOLE_WIDTH, CONSOLE_HEIGHT, "Bloodthirsty");
        }
    }

    public static void closingCredits(int cWidth, int cHeight, String winType) throws InterruptedException, IOException, LineUnavailableException, UnsupportedAudioFileException, FontFormatException {

        /** drawTitle
         * Description: This method draws the title
         *
         * @ cWidth
         * console width
         *
         * @ cHeight
         * console height
         *
         * @ winType
         * the type of victory earned by the user
         *
         * @throws InterruptedException
         * For using Thread.sleep()
         *
         * @throws IOException
         * For playing music
         **/

        //clears the background
        c.setBackgroundColor(new Color(59, 190, 247)); //background colour (light blue)
        c.clear();

//possible total samples
        int possibleSamples = 0;

        //code to start the music
        File sound3 = new File ("/Users/nathankowal/Documents/CodeProjects/11Culm/src/ClosingCreditsMusic.wav");;

        String closingMessage [] = {"", "", "", "", "", "", "", "", "", "", "", "", ""};

        if(winType.equals("Adventurous")) {
            closingMessage[0] = "Two Years Later:";
            closingMessage[1] = "The new human city, Yucarte, has flourished in the oasis discovered by Dr. Zoë Adams";
            closingMessage[2] = "and her team. Now with two cities on Janus, humankind is thriving. Dr. Adams and";
            closingMessage[3] = "her entire team has been awarded the highest level of honour for their discoveries.";
            closingMessage[4] = "More expeditions are sent into the Blurb daily. Life is good for everyone";
            closingMessage[5] = "\n";
            closingMessage[6] = "You have been awarded the honour, along with the rest of the team, for your calm";
            closingMessage[7] = "and collected communication with Dr. Adams the whole way through. You are enjoying";
            closingMessage[8] = "life and plan to sign up for a future expedition into the Blurb.";

            possibleSamples = 2;

            sound3 = new File ("/Users/nathankowal/Documents/CodeProjects/11Culm/src/ClosingCreditsMusic.wav");
        }

        if(winType.equals("Heroic")) {
            closingMessage[0] = "Two Years Later:";
            closingMessage[1] = "Foramor has been revitalized through the power of the ardenium found in the Blurb.";
            closingMessage[2] = "New homes, schools, and hospitals have been constructed for the booming population.";
            closingMessage[3] = "Dr. Adams and her team were all awarded medals of honour for their courageousness";
            closingMessage[4] = "in venturing into the Blurb.";
            closingMessage[5] = "\n";
            closingMessage[6] = "You have been awarded the honour, as well, but you plan to take your hero status as is";
            closingMessage[7] = "and stay away from scientific expeditions for the time being.";


            possibleSamples = 4;

            sound3 = new File ("/Users/nathankowal/Documents/CodeProjects/11Culm/src/ClosingCreditsMusic.wav");
        }

        if(winType.equals("Greedy")) {
            closingMessage[0] = "Two Years Later:";
            closingMessage[1] = "Foramor's economic state has continued to decline. In a tragic event, Dr. Zoë Adams and";
            closingMessage[2] = "her team vanished without a trace. The public mourns their losses and hopes for a ";
            closingMessage[3] = "brighter future.";
            closingMessage[4] = "\n";
            closingMessage[5] = "You got your 10 billion credits wired from Hudson, then immediately cut communications";
            closingMessage[6] = "from your terminal. You reported to your superiors that the transmission mysteriously";
            closingMessage[7] = "disconnected from Dr. Adams' end. You quit your job the next day, and now live in a";
            closingMessage[8] = "gorgeous house in the wealthy area of Foramor. You spend your days living lavishly, but";
            closingMessage[9] = "the guilt of what you did to accomplish it hangs over you.";

            possibleSamples = 4;

            sound3 = new File("/Users/nathankowal/Documents/CodeProjects/11Culm/src/ClosingCreditsMusicDark.wav");
        }

        if(winType.equals("Patriotic")) {

            closingMessage[0] = "Two Years Later:";
            closingMessage[1] = "Foramor has been revitalized through the power of the ardenium found in the Blurb. New";
            closingMessage[2] = "homes, schools, and hospitals have been constructed for the booming population. Hudson";
            closingMessage[3] = "Rain was apprehended and arrested by government officials. He is now serving time in";
            closingMessage[4] = "prison for treason and sabatoge.";
            closingMessage[5] = "\n";
            closingMessage[6] = "You were awarded the highest of all honours by the government of Foramor for saving";
            closingMessage[7] = "the three members of the team, as well as the entire population back in Foramor. Dr. Zoë";
            closingMessage[8] = "Adams, Akari Hakyen, and Mikayla Deivass were forever thankful for what you did, and";
            closingMessage[9] = "you all remain great friends to this day. They too were honoured for their bravery upon";
            closingMessage[10] = "their return. As a result of your valiant actions, you shot to fame in Foramor. Inspired";
            closingMessage[11] = " by the people, the prime minister appointed you as one of his advisers, which you do";
            closingMessage[12] = "every day with pride. Life is good.";

            possibleSamples = 4;

            sound3 = new File ("/Users/nathankowal/Documents/CodeProjects/11Culm/src/ClosingCreditsMusic.wav");
        }

        if(winType.equals("Peaceful")) {

            closingMessage[0] = "Two Years Later:";
            closingMessage[1] = "The last two years have been defined as a period of mass immmigration from Foramor to";
            closingMessage[2] = "the new city on the shores of lake Bordia (as called by the aliens), Wakia. Wakia has become";
            closingMessage[3] = "a hub for science, technology, and research, as alien scientists inspire humankind to think";
            closingMessage[4] = "in entirely new ways. Mikayla Deivass, the leader of the famed negotiations, is now the";
            closingMessage[5] = "head of the joint human-alien relations division, tasked with integrating the two socities";
            closingMessage[6] = "seamlessly.";
            closingMessage[7] = "\n";
            closingMessage[8] = "The entire team expedition, including you, were awarded prizes for their peacekeeping";
            closingMessage[9] = "efforts, and remaining open minded in new situations. Now, you are preparing to move";
            closingMessage[10] = "with your family to Wakia to experience the hype for yourself. You are looking forward";
            closingMessage[11] = "to seeing the now famous black sand of lake Bordia, after countless of artist depictions";
            closingMessage[12] = "based on your team's descriptions.";

            possibleSamples = 3;

            sound3 = new File ("/Users/nathankowal/Documents/CodeProjects/11Culm/src/ClosingCreditsMusic.wav");
        }

        if(winType.equals("Bloodthirsty")){

            closingMessage[0] = "Two Years Later:";
            closingMessage[1] = "After the war ended, humans slowly starting moving to the new city, Kardite, on the shores";
            closingMessage[2] = "of the black sand lake. The first immigrants are tasked with rebuilding the infrastructure";
            closingMessage[3] = "ravaged by war and attempting to form relationships with the aliens on the other side of";
            closingMessage[4] = "the wall. Citizens will constantly have to worry, but it is still better than running out of";
            closingMessage[5] = "room in Foramor.";
            closingMessage[6] = "\n";
            closingMessage[7] = "After making the decision to go to war, Dr. Adams and her team, including you, have been";
            closingMessage[8] = "shunned by the public for being hostile towards an innnocent alien race. You were forced";
            closingMessage[9] = "out of the public eye, although the military protected you, your job, and your family. At";
            closingMessage[10] = "least there is consoltation that you found the spot for a new city.";

            possibleSamples = 3;

            sound3 = new File ("/Users/nathankowal/Documents/CodeProjects/11Culm/src/ClosingCreditsMusicDark.wav");
        }

        c.clear();

        //code to start the music
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(sound3);

        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip audioClip = (Clip) AudioSystem.getLine(info);

        audioClip.open(audioStream);
        audioClip.start();

        c.setColor(new Color(54, 40, 239));
        Font astro = Font.createFont(Font.TRUETYPE_FONT, FullGame.class.getResourceAsStream("Astro.ttf"));
        c.setFont(astro.deriveFont(Font.PLAIN, 25));

        for(int y = cHeight + 50; y >= -400; y -=2){

            for(int i = 0; i < closingMessage.length; i ++){

                c.drawString(closingMessage[i], 100, y + i * 30);
            }

            Thread.sleep(7);
            c.clear();

        }


        c.setColor(new Color(54, 40, 239));
        c.setFont(astro.deriveFont(Font.PLAIN, 50));
        c.drawString("Statistics", 100, 100);

        c.setFont(astro.deriveFont(Font.PLAIN, 30));
        c.drawString("You won the " + winType + " way", 100, 150);

        if(samplesCollected == 1){
            c.drawString("You collected " + samplesCollected + " sample (out of a possible " + possibleSamples + ")", 100, 200);
        }

        else{
            c.drawString("You collected " + samplesCollected + " samples (out of a possible " + possibleSamples + ")", 100, 200);
        }


        if(programCrashes == 1){
            c.drawString("You crashed the program " + programCrashes + " time", 100, 250);
        }

        else{
            c.drawString("You crashed the program " + programCrashes + " times", 100, 250);
        }


        Thread.sleep(10000);

        //credits
        c.setColor(new Color(54, 40, 239));
        c.setFont(astro.deriveFont(Font.PLAIN, 25));

        String credits [] = {"                                                  An Original Story by Nathan Kowal",
                "\n", "\n", "\n", "\n",
                "                                                  Story                        Nathan Kowal",
                "                                                  Design                      Nathan Kowal",
                "                                                  Programming           Nathan Kowal",
                "\n", "\n", "\n", "\n",
                "This is a fictional story. Any similarities to real people or real life events are unintended.",
                "                                   Created for Grade 11 Computer Science Culminating"};

        for(int y = cHeight + 50; y >= -400; y -=2){

            for(int i = 0; i < credits.length; i ++){

                c.drawString(credits[i], 100, y + i * 30);
            }

            Thread.sleep(7);
            c.clear();

        }

        c.setColor(new Color(54, 40, 239));
        c.setFont(astro.deriveFont(Font.PLAIN, 100));

        for(int y = cHeight + 50; y >= -400; y -=2){

            c.drawString("THE BLURB", cWidth/2 - 175, y + 1 * 30);

            Thread.sleep(7);
            c.clear();

        }

        //stop the music
        audioClip.close();
        audioStream.close();

        c.close();

    }

    public static void main (String [] args) throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException, FontFormatException {

        c = new Console (CONSOLE_WIDTH, CONSOLE_HEIGHT, "The Blurb");

        //first choice: jungle or soil?
        char pathwayChoice1 = 'X';

        //second choice: lake or cave?
        char pathwayChoice2 = 'X';

        //second choice: war or peace?
        char pathwayChoice3 = 'X';

        drawTitle(CONSOLE_WIDTH/2 - 225, 300);
        openingCredits(CONSOLE_WIDTH, CONSOLE_HEIGHT);

        //code to start the music

        File sound4 = new File ("/Users/nathankowal/Documents/CodeProjects/11Culm/src/FullGameMusic.wav");

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(sound4);

        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip audioClip = (Clip) AudioSystem.getLine(info);

        audioClip.open(audioStream);
        audioClip.start();

        openConsole();
        sequenceOne();
        sequenceTwo();

        //sets variable pathwayChoice1 to the return of sequenceThree (either J or S)
        pathwayChoice1 = sequenceThree();

        //completes the following sequence if the user chooses the jungle
        if(pathwayChoice1 == 'J'){
            jungleSequence();
            desertSequence();

            audioClip.close();
            audioStream.close();
            oasisSequence();
        }

        //completes the following sequence if the user chooses the soil
        if(pathwayChoice1 == 'S'){

            //sets variable pathwayChoice2 to the return of waterSequence (either C or L)
            pathwayChoice2 = waterSequence();

            //completes the following sequence if the user chooses the cave
            if(pathwayChoice2 == 'C'){
                caveSequence();

                audioClip.close();
                audioStream.close();
                metalSequence();
            }

            //completes the following sequence if the user chooses the lake
            if(pathwayChoice2 == 'L'){
                lakeSequence();

                //sets variable pathwayChoice3 to the return of alienSequence (either W or P)
                pathwayChoice3 = alienSequence();

                //completes the following sequence if the user chooses the war
                if(pathwayChoice3 == 'W'){
                    audioClip.close();
                    audioStream.close();
                    warSequence();
                }

                //completes the following sequence if the user chooses peace
                if(pathwayChoice3 == 'P'){
                    audioClip.close();
                    audioStream.close();
                    peaceSequence();
                }

            }

        }
    }

}