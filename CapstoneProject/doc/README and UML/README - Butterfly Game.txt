Butterfly Game
Authors: Emily Choi, Asha LaManque, Claire Oh
Revision: 5/20/22


Introduction: 
You're a butterfly ready to embark on a new adventure to discover yourself and the world around you. You want nothing more than to spread your wings and soar along with the clouds. As a butterfly, the world is a dangerous place for you, but you have a dream to explore as much of it as possible. In this side-scrolling runner game, you will be dropped into this deadly, but exciting world as an egg, but will slowly grow over time into a caterpillar, a pupa, and eventually a butterfly. Before you start, you’ll get the opportunity to choose what kind of butterfly you’ll end up being. To live out your dream you will have to avoid all potential enemies and obstacles and consume enough food. If you run into an obstacle or enemy or don’t eat enough, you will die. This isn’t the end of the world as you’ll reset back to the start of the section you perished in. Our primary goal in writing this program is to create a fun and interesting game that people will be able to enjoy while learning more about the life cycle of butterflies. The primary feature of our program is the main side scroll-esque game with a character selection feature at the start. The game will include the different phases which will change the style of the game. Our primary user base would be people who enjoy games.  


Instructions:
This program is divided into phases, in which each phase represents a different task. Each phase can be attempted an unlimited amount of times until the player succeeds in completing the phase. The game starts with a menu and some instructions. In the first phase, you are an egg, ready to emerge as a caterpillar. Click on the screen to cycle through any designs/color combinations. Once a design is selected, press the spacebar. There will then be a transition screen where users can choose to view instructions for the next phase or start the caterpillar phase. Once ready, click the start button. The next phase is the caterpillar phase. Up and down arrow keys will be used to toggle between movements such as jump and dive. If the user moves through a collectible, such as a leaf, it is automatically collected. The caterpillar must avoid obstacles and predators to survive. Anything that is not a leaf is considered harmful. Predators, which are animals, can instantly harm the caterpillar. Obstacles can only harm a caterpillar after three collisions. After 7 leaves are collected, if you survive, the next phase (pupa) occurs after another menu screen and an option to view instructions. In this stage, press the corresponding arrow keys when they intersect with a flower. If enough points are reached, the caterpillar will emerge as a butterfly in the next phase. Before this phase, a transition menu occurs. Press start when ready or click to view instructions. For the butterfly phase, use the arrow keys again to avoid obstacles and predators and collect flowers. A similar rule applies to the butterfly phase as the caterpillar phase. Any animal is a predator. One collision can instantly harm a butterfly. However, 3 collisions with obstacles, non-animals objects other than flowers, are required to harm a butterfly. After 5 flowers are collected, the butterfly’s journey will then. When it does, click the exit button on the screen. 


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
* Starting menu that allows users to select butterfly sprite type or start the game. (Butterfly sprite type selection will dictate the player’s sprite during the butterfly phase of the game, with the differencing between the sprites being appearance)
* Two-Dimensional pixel graphics with basic colors and symbols. Graphics will mostly be composed of various sprites placed on a pixel-styled background.[a]
* Players control a character as it runs in an automatic side scrolling map[b] to avoid obstacles and collect the required amount of “leaf” collectibles to pass the phase. Players can use the up and down arrow keys to make their characters jump or crouch/fly up or down[c]. Obstacles will be located at certain heights as they move closer to the character and the player will have to avoid them by moving their character. Obstacles differentiate from one another based on shape and size. For example, some objects may be rectangular in shape and others may be circular.      
* Game has multiple phases that correspond to the butterfly life cycle. These phases will affect the graphics and obstacles that the player will encounter. For example, the butterfly phase will contain obstacles that are attached to both the top and bottom [d]of the screen as compared to the caterpillar phase, which only will have obstacles attached to the bottom of the screen. However, a type of obstacle (a predator) differs from this rule. They are located roughly midway in the screen. The purpose being to make collecting collectibles, like leaves more difficult. Aside from this, predators operate similarly, with the exception of possibly different graphics or designs. 
* Players can win or lose the game through collision with obstacles or hunger (player has not collected enough “leaves” during caterpillar phase) and then can replay the phase they died in, an unlimited number of times until they die. Players can replay the phase they are in an unlimited number of times until they are able to move on. 
* Obstacles that move along with the side scrolling map that the player has to jump over with the up arrow key as a caterpillar or duck and jump with the up and down arrow key as a butterfly


Want-to-have Features:
* Starting menu that allows users to customize a butterfly sprite type. This could allow for customization of different colors. 
* GUI bar that indicates hunger in relation to the amount of “leaves” the player has collected. If the bar goes down to zero, the player dies. Next to the bar will be the exact number of leaves consumed. If there is a surplus amount the bar appears the same. However, the number on the side will still increase. 
* Animated two-dimensional graphics with colors and symbols. Animation in this case refers to movement. For instance, an animated butterfly will be shown moving its wings. 
* An additional game phase where the player’s sprite becomes a cocoon (which would be played after the caterpillar stage) and they must repeatedly press a button to release it; this phase may look like a rhythm game. Once the player wins this part of the game, the cocoon hatches. Then the play continues with the butterfly stage. 
* A high score system in the menu that keeps track of the highest score which is based on how many collectibles (for example, leaves) the player picks up during their run.
* Have a certain amount of times a player can play each phase. If they can’t pass the phase in a certain amount of tries, the game restarts back to the egg. 


Stretch Features:
* Three-dimensional graphics with colors and symbols.  [e]
* Multiplayer functions that allow for a split screen effect for two players to play the game at the same time and compete against each other.  
* Multiplayer functions that allow for users on different computers to play the game at the same time and compete against each other.   




Class List:


* Main - Initiates the game
* DrawingSurface - Holds all the panels (of the different phases)
* Screen (abstract) - Represents a screen, or the UI
* EggPanel (extends Screen) - the graphics for the egg phase, allows the user to select a butterfly design
* CaterpillarPanel (extends Screen)  -  the graphics for the caterpillar phase
* ButterflyPanel (extends Screen) -  the graphics for the butterfly phase
* MenuPanel (extends Screen)  - the start point and transitions of the game, which allows the user start/restart phases and view instructions for particular phases. 
* ResetPanel (extends Screen) - Resets the phase in the game
* InstructionsPanel (extends Screen) - Shows players game instructions 
* EndPanel (extends Screen) - Exits out of the game
* HealthBar (extends Screen) - the GUI for the number of collectibles and a player’s health
* RhythmPanel (extends Screen) - the graphics for the rhythm game
* Player (abstract) - Holds primary player information, such as the image of a player’s sprite and the movement of the player
* Egg (extends Player) - Represents the player during the egg phase[f]
* Caterpillar (extends Player) - Represents the player during the caterpillar phase
* Butterfly (extends Player) - Represents the player during the butterfly phase
* Element - Represents any game element in which the player collides with 
* Obstacle (extends Element)- Represents any obstacle that the player may encounter; this is an obstacle that the player can collide with three times before having to reset the phase
* Predator (extends Element) - Represents any predator that the player may encounter; this is an obstacle which will automatically kill the player when collided
* Collectible (extends Element) - Represents a collectible (such as flowers or leaves) that the player eats
* GIF - Displays an animated gif file
* SoundJLayer (extends PlaybackListener implements Runnable) - Plays the sound file given
* DrawingSurface (extends PApplet) - Draws and manages all the screens
* Beat (extends Element) - Represents elements on the screen in regard to music


Credits:


Libraries Referenced/Main Credits:
* PhysicsGameDemo
* Asha’s Shapes Library
* JaysEasierSound 
* Jl1.0.jar
* Leo Yu (Music Composition)


Responsibilities List:
* Asha - Egg, EggPanel, Player, Main, MenuPanel, Collectible, EndPanel, HealthBar, InstructionsPanel, ResetPanel, found the majority of sprites for beta-version
* Claire - Butterfly, ButterflyPanel, Predator, Obstacle, Element, Beat, RhythmPanel found obstacle sprite for the beta version, Designed Sprites for final version
* Emily - Caterpillar, CaterpillarPanel, DrawingSurface, Screen, RythmPanel, Designed Sprites for final version
* All- Help debug other’s classes to help with the functionality and overall cohesion of the program
Help:


https://stackoverflow.com/questions/1439022/get-mouse-position 


https://examples.javacodegeeks.com/desktop-java/awt/event/simple-key-press-listener/#:~:text=Use%20KeyEvent.,which%20key%20the%20user%20pressed. 


https://thiscouldbebetter.wordpress.com/2011/06/14/playing-an-mp3-from-java-using-jlayer/ - Helped with the SoundJLayer class and setting up audio


https://stackoverflow.com/questions/28570841/cant-get-audio-file-to-play 




Images/Sprites (Links to Source):


Butterfly 1 - https://stock.adobe.com/images/vector-pixel-art-colorful-butterfly-isolated-butterfly-on-white-background/250521442 
Butterfly 2 - https://www.vectorstock.com/royalty-free-vector/pixel-butterfly-vector-37581561 
Butterfly 3 - https://www.vectorstock.com/royalty-free-vectors/butterfly-pixel-art-vectors 
Caterpillar - https://www.dreamstime.com/illustration/vector-pixel-art-caterpillar.html 
MenuPanel Background - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.artstation.com%2Fmarketplace%2Fp%2F1VPz%2Fpixel-art-forest&psig=AOvVaw30JRCJeXGe88KWqMzm2gAM&ust=1652390709263000&source=images&cd=vfe&ved=0CA0QjhxqFwoTCMC74Z2x2PcCFQAAAAAdAAAAABAD 
EggPanel Background - https://www.pinterest.com/pin/119275090114721076/ 
Extra Background - https://kentangpixel.itch.io/16x16px-night-forest-tileset 
Predator - https://www.google.com/url?sa=i&url=https%3A%2F%2Fstock.adobe.com%2Fimages%2Fvector-pixel-art-bird-fly%2F184444623&psig=AOvVaw2T18hzRVV2gqb0uNNJvjmW&ust=1652390805046000&source=images&cd=vfe&ved=0CA0QjhxqFwoTCOi4mcux2PcCFQAAAAAdAAAAABAI 
Flower- https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.clipartkey.com%2Fview%2FmwJhRJ_pixel-art-flower-easy%2F&psig=AOvVaw1GwZEiOz4qxFguE4deYE6v&ust=1652391072139000&source=images&cd=vfe&ved=0CA0QjhxqFwoTCOjkscmy2PcCFQAAAAAdAAAAABAT 
Leaf - https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.123rf.com%2Fphoto_85163505_vector-pixel-art-leaf-isolated.html&psig=AOvVaw34up25nU_TvXd4g4Laugi0&ust=1652391186155000&source=images&cd=vfe&ved=0CA0QjhxqFwoTCICmxYCz2PcCFQAAAAAdAAAAABAD 
Kite - ​​https://www.brik.co/blogs/pixel-art/kite-flying-day-pixel-art 




Music:


Music used from Leo Yu


Extra Music in Our Project:
Gnossienne no. 1 


Great brilliant Waltz Opus 18 no. 1 


Organ Concerto in B-flat major, HWV 290 


Arabesque - Scherzando 


Libraries Used:
Processing
Point
Java awt
Java swing
Java Util ArrayList
Java Util List
JavaZoom (JLayer)
