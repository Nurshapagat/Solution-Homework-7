# 🎓 Solution-Homework-7

This project demonstrates the Iterator Pattern (Part 1) and Mediator Pattern (Part 2) via two realistic simulations: a Netflix-like episode player and an Airport Tower simulator.

# Part 1 – Iterator Pattern

## Overview

This module implements the Iterator design pattern to allow uniform traversal of TV episodes across multiple seasons, regardless of how they’re stored (e.g., ArrayList, LinkedList, lazy-loaded file). The system supports normal, reverse, and shuffle traversal. It also includes optional decorators for skipping intros and filtering out already watched episodes.

## 🧱 Design Structure

### Core Classes

- **Episode:** Represents a single episode (title + runtime).

- **Season:** Contains a collection of episodes (any storage format).

- **Series:** Represents the whole show; contains multiple seasons.

- **EpisodeIterator:** Interface with hasNext() and next().

### Iterator Implementations

- **SeasonIterator:** Iterates episodes in normal order.

- **ReverseSeasonIterator:** Iterates episodes in reverse order.

- **ShuffleSeasonIterator:** Random order with fixed seed for consistency.

- **BingeIterator:** Chains episodes from all seasons in order.

### Decorator Iterators (Bonus)

- **SkipIntroIterator:** Skips the first N seconds of each episode.

- **UnwatchedFilterIterator:** Only returns episodes not marked as watched.

### Utility

- **EpisodeView:** Represents a playable view starting at offset.

- **EpisodeGenerator:** Used to generate 10,000 test episodes.

### 💡 Features Implemented

✅ Iterator interface with hasNext() and next()

✅ Multiple traversal orders (normal, reverse, shuffle)

✅ Season implements Iterable<Episode>

✅ Binge viewing across all seasons

✅ Decorators: Skip Intro & Watch History Filter

✅ Stretch Goal: Performance test on 10,000 episodes


# Part 2 – Mediator Pattern

## Overview

This part simulates air traffic control using the Mediator design pattern. Planes no longer communicate directly — all coordination is centralized in a ControlTower, which manages landings, takeoffs, and emergencies.

## 🧱 Design Structure

### Interfaces & Abstracts

- **TowerMediator:** Defines broadcast() and requestRunway() methods.

- **Aircraft (abstract):** Base class with ID, receive(), and send() methods.

### Concrete Classes

- **ControlTower:** Implements TowerMediator. Manages queues for landing and takeoff.

- **PassengerPlane, CargoPlane, Helicopter:** Extend Aircraft. Display custom behavior when receiving tower messages.

### Strategy Pattern (Bonus)

- **RunwayScheduler (Interface)** - Decouples scheduling logic from the tower itself.

- **FuelPriorityScheduler (Strategy Implementation)** - Prioritizes aircraft based on fuel levels (lower fuel = higher priority).

#### AirportSimulation - Simulation Driver
Spawns 10 random aircraft with randomized fuel levels.
Uses ScheduledExecutorService to simulate behavior every second.

### 💡 Features Implemented

✅ Centralized mediator via ControlTower

✅ FIFO runway queue

✅ Emergency protocol (MAYDAY handling)

✅ Simulation driver with real-time actions
 
