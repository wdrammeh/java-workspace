# Inheritance

- All constructors in a subclass delegate to the default constructor in the super class, unless where specified.
- If the super class defines no default constructor out of multiple constructors present, then it becomes incumbent ipon all the constructors in a subclass to explicitly make a super call as to which constructor to infer.
- Abstract classes are intended to be extended; and where extended, all abstract methods must be implemented, unless, of course, where the implementing type is itself abstract.
- Interfaces are entirely abstract.