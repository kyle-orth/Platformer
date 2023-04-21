# Platformer
My attempt at a simple platforming game. 
Included will be a functional game engine, created from scratch using integrated java libraries.

**Game Engine Components**

*GameElements*: A package storing tools for level building. This includes various types of platforms with appropriate collision-testing, and Entities, the base class for movable objects such as enemies, projectiles, and the player.

*GraphicElements*: This package will allow the game to be visually displayed on screen. It implements the built-in javax.swing library.

*InputElements*: This package identifies user input (keystrokes).

*PhysicsElements*: This is the physics engine, handling all moving components of the game. The Movement class can move Entities based on their velocity and the time elapsed since the last frame, as well as applying gravity. The Clock should be used to track time, with the Clock.tick() method being called every frame.
