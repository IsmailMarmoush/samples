Software Specs
(PC Side-High Level)

Functional Requirements:
Control Per Motor Technique
Using defined point in 3D for the end of the link.
Using defined angle value.
Using Keyboard Arrows.
Control For the Robotic Arm
Control the End Effector using defined point in 3d and all the motors shall adapt to that and make the end effector reach that point
Control the End Effector using Keyboard Arrows
Speed Control - A - z
M1, M2.... Mx Selection using TAB
Control base directions through right and left
Control rest of motors through up and down
Saving Motion Frames
Frames are records of the position and time for each Node lies on the surface of the robotic arm.
Ability to set the Frames ratio (Number of frames per second).
The ability to record any previous set of frames and replay it
The ability to set the speed between any frame and the next frame
The ability to set the average speed over set of frames
The ability to insert number of frames between two frames (Automatically, Manually)
Playing The Frames:
The ability to speed up or slow down (very hard, the robot will have to make instant time changes to the path )
pick up paths
GUI
Will be using Eclipse RCP (Rich Client Platform)
Should contain Synced view of the robot (TOP, Side)
Table of Frames(each joint 3d point and time) and angles of each link based on what ? (Kinematics problem)
Table of signals sent and received

Non-functional Requirements:
Performance / response time (performance engineering)
System Is a real time System; which means it should have momentarily calculation speed that would affect system to be based on large grain components and less messages between classes.
Documentation
Efficiency (resource consumption for given load)
Multi-threading should be used to increase the efficiency in that case is a +1 point in favor of Java SE
Open source
SVN or CVS to be used through Code.google.com or  Sourceforge.com
Response time
As mentioned in performance it should be momentarily
Safety
safety of the robot movements should be taken seriously
feed back will be used to guard the robot movements and multiple checks would take place , also real time errors and warnings should appear on the user interface.
Robustness
Robustness would be applied through Intensive Exception handling techniques
Testing should also be taken seriously to avoid as much as errors that would appear


