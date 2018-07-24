package com.udacity.gradle.jokerjavalibrary;

import java.util.Random;

public class Joker {

    // jokes from https://metro.co.uk/2015/11/26/the-ten-funniest-jokes-ever-according-to-science-5527698/
    private static final String[] funnyJokes = {
            "A guy is sitting at home when he hears a knock at the door. He opens the door " +
                    "and sees a snail on the porch. He picks up the snail and throws it as far " +
                    "as he can. Three years later there’s a knock on the door. He opens it and " +
                    "sees the same snail. The snail says: ‘What the hell was that all about?’",
            "Three guys stranded on a desert island find a magic lantern containing a genie, who " +
                    "grants them each one wish. The first guy wishes he was off the island and " +
                    "back home. The second guy wishes the same. The third guy says: ‘I’m lonely. " +
                    "I wish my friends were back here.’",
            "It’s the World Cup Final, and a man makes his way to his seat right next to the " +
                    "pitch. He sits down, noticing that the seat next to him is empty. He leans " +
                    " and asks his neighbour if someone will be sitting there. ‘No,’ says the " +
                    "neighbour. ‘The seat is empty.’ ‘This is incredible,’ said the man. ‘Who in " +
                    "their right mind would have a seat like this for the Final and not use it?’ " +
                    "The neighbour says, ‘Well actually the seat belongs to me. I was supposed to " +
                    "come with my wife, but she passed away. This is the first World Cup Final we " +
                    "haven’t been to together since we got married.’ ‘Oh, I’m so sorry to hear " +
                    "that. That’s terrible….But couldn’t you find someone else, a friend, " +
                    "relative or even a neighbour to take her seat?’ The man shakes his head. " +
                    "‘No,’ he says. ‘They’re all at the funeral.’",
            "A guy shows up late for work. The boss yells, ‘You should’ve been here at 8.30!’ He " +
                    "replies. ‘Why? What happened at 8.30?’",
            "Sid and Irv are business partners. They make a deal that whichever one dies first " +
                    "will contact the living one from the afterlife. So Irv dies. Sid doesn’t " +
                    "hear from him for about a year, figures there is no afterlife. Then one day " +
                    "he gets a call. It’s Irv. ‘So there is an afterlife! What’s it like?’ Sid " +
                    "asks. ‘Well, I sleep very late. I get up, have a big breakfast. Then I have " +
                    "sex, lots of sex. Then I go back to sleep, but I get up for lunch, have a " +
                    "big lunch. Have some more sex, take a nap. Huge dinner. More sex. Go to " +
                    "sleep and wake up the next day.’ ‘Oh, my God,’ says Sid. ‘So that’s what " +
                    "heaven is like?’ ‘Oh no,’ says Irv. ‘I’m not in heaven. I’m a bear in " +
                    "Yellowstone Park.’",
            "A guy dies and is sent to hell. Satan meets him, shows him doors to three rooms, " +
                    "and says he must choose one to spend eternity in. In the first room, people " +
                    "are standing in dirt up to their necks. The guy says, ‘No, let me see the " +
                    "next room.’ In the second room, people are standing in dirt up to their " +
                    "noses. Guy says no again. Finally Satan opens the third room. People are " +
                    "standing with dirt up to their knees, drinking coffee and eating pastries. " +
                    "The guy says, ‘I pick this room.’ Satan says Ok and starts to leave, and the " +
                    "guy wades in and starts pouring some coffee. On the way out Satan yells, " +
                    "‘OK, coffee break’s over. Everyone back on your heads!’",
            "A young boy enters a barber shop and the barber whispers to his customer. ‘This is " +
                    "the dumbest kid in the world. Watch while I prove it you.’ The barber puts " +
                    "a dollar bill in one hand and two quarters in the other, then calls the boy " +
                    "over and asks, ‘Which do you want, son?’ The boy takes the quarters and " +
                    "leaves. ‘What did I tell you?’ said the barber. ‘That kid never learns!’ " +
                    "Later, when the customer leaves, he sees the same young boy coming out of " +
                    "the ice cream store. ‘Hey, son! May I ask you a question? Why did you take " +
                    "the quarters instead of the dollar bill?’ The boy licked his cone and " +
                    "replied, ‘Because the day I take the dollar, the game is over!’",
            "China has a population of a billion people. One billion. That means even if you’re " +
                    "a one in a million kind of guy, there are still a thousand others exactly " +
                    "like you.",
            "Two campers are walking through the woods when a huge brown bear suddenly appears " +
                    "in the clearing about 50 feet in front of them. The bear sees the campers " +
                    "and begins to head toward them. The first guy drops his backpack, digs out " +
                    "a pair of sneakers, and frantically begins to put them on. The second guy " +
                    "says, ‘What are you doing? Sneakers won’t help you outrun that bear.’ ‘I " +
                    "don’t need to outrun the bear,’ the first guy says. ‘I just need to outrun " +
                    "you.’",
            "A guy meets a sex worker in a bar. She says, ‘This is your lucky night. I’ve got a " +
                    "special game for you. I’ll do absolutely anything you want for £300 as long " +
                    "as you can say it in three words.’ The guy replies, ‘Hey, why not?’ He " +
                    "pulls his wallet out of his pocket and lays £300 on the bar, and says " +
                    "slowly. ‘Paint…my….house.’"
    };

    public String getJoke() {
        Random random = new Random();
        return funnyJokes[random.nextInt(funnyJokes.length)];
    }
}
