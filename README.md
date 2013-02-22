-----------------------
Scheduling Optimization
-----------------------

    -- Project description --

    This project is designed to provide insight into the challenge of class scheduling as a programming
    challenge. The primary focus of the project revolves around optimizing schedules to minimize overlap
    I have attempted to solve at least some of the challenges regarding this problem by focusing on 
    simplifying the problem down to its core. When this project was started, I had no use cases, so it may
    not be applicable to all cases or all conditions. I've made what I consider to be liberal assumptions
    on the nature of scheduling and on the input data that is coming into the system. I outline most of those
    assumptions below.
	
    -- Assumptions --

    1.  There are 10080 minutes in a week. We index minute blocks from 0 to 10079.
    2.  A single minute block may exist in up to Integer.MAX_VALUE meetings. 
    3.  We don't care about units smaller than minutes.
    4.  We don't handle floats. Instead we take a string and convert it to an integer index. 
    5.  Courses can have multiple meeting times.
    6.  Two courses cannot have the same ID string.
    7.  Meeting times are contained inside a single day (do not overlap).
    8.  A thirty minute meeting time goes from 10:00 to 10:29, not 10:30.
    9.  We do not care about meeting dates, all courses are assumed to meet each week and repeat.
    10. Courses without at least one meeting time can be ignored.
    11. Meeting times that are negative or 0 can be ignored.

    	