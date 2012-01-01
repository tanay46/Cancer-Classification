PROJECT TITLE: NEAREST NEIGHBOR ALGORITHM TEST
PURPOSE OF PROJECT: Test the accuracy of the Nearest Neighbor and K Nearest Neighbor algorithms on a dataset.
DATE: 12/10/10
AUTHOR: Tanay Jaipuria
USER INSTRUCTIONS: 
Run the main method in the NearestNeighborTester class. As a command line input, enter the name of the dataset, which should be wdbc.data
The program will then run, and print out the average accuracy of the algorithm.

If you do not enter a command line arguement, the program terminates displaying an error message.
If the file of the name you specify isn't found, the program prompts you to re-enter the name of the file.

How the Program Works

NearestNeighborTester Class
In the NearestNeighborTester class, there is a method readFile which takes a line of input at a time, and then calls ParseLine, which puts it into an array. The first number on every row which is the id is ignored, and the classification is converted to doubles. M = 1.0 and B = 0.0
The readFile is called from the main method, and thus, an array containing all the data is created.

Then, inside a for loop in the main method, a new NearestNeighbor object is created, and the getNearestNeighborAccuracy is called.
This is then done with the KNearestNeighbor method of the NearestNeighbor class, for different values of K

NearestNeighbor Class

Random20 method
- generates a list of numbers between 0 and 569 
- it makes sure that duplicates aren't included.
- this is done till an array of length 114 is filled.

CreateArrays method
- the data occouring at indexes of the data array occuring in the list generated above is put into the test data array. 
- The rest is put into the training data array.

Now there are two arrays, one with the points whose classification is known(training data) and the test data whose classification has to be predicted.

findDistance method
- simply finds the distance between two 1 dimensional arrays sent to it.
- ignores the first number, which has the number for the classification.

findNearestNeighborAccuracy
- finds the accuracy by finding the closest point to each point in the test data, and checking what it is.
- it then compares this to what the point actually is.
- if they are the same, it increases the number it predicted correctly
- it then returns the percentage that were correct

getNearestNeighborAccuracy
- simply calls the random20, createArrays and findNearestNeighborAccuracy, returning the accuracy for that test.

getDistances
- returns an array with the distances between a point in test data and all points in training data, and the classification of the point in the training data.

sortDistances
- sort the array with distances and returns the sorted array

kNearestNeighbor
- calls Random20
- calls createArrays
- for every point in the test data, it calls getDistances, sortDistances, and then compares the first k values of the sorted array to see whether they are malignant or benign
- whichever occurs more becomes the predictedvalue
- this is then compared with the actual value
- if they are equal the number of correct is incremented.
- the accuracy is then returned.

-it allows a parameter for the k value to be used.

PROGRAM OUTPUT
- For the nearest neighbor algorithm, the accuracy was about 91%
- For the k-nearest neighbor algorithm, the accuracy was 92 for k=3, and about 93 for both k=5 and k=7
- Thus the accuracy seems to increase as the value of k increases.






