#!/usr/bin/python
from __future__ import division
import os
import csv
from string import punctuation

filelist = os.path.join(os.getcwd(), "output.txt") 
tweets = file(filelist, "r").read()
tweets_list = tweets.split('\n')
fp = file(os.path.join(os.getcwd(), "wrongdecision.txt"), "w")

#print tweets_list[0],"\n",tweets_list[1],"\n",tweets_list[2]

right = 0
wrong = 0

for i in range(0, len(tweets_list)): 
#for i in range(0, 3): 
    
    tweet_processed=tweets_list[i].lower()
        
    for p in list(punctuation):
        tweet_processed=tweet_processed.replace(p,'')

    tweet_processed=tweet_processed.replace("\t",' ')
    tweet_processed=tweet_processed.replace("\r",'')
    
    words=tweet_processed.split(' ')

    if words[0] == "positive": 
        if words[1] == '5':
            right += 1
        else:
            wrong += 1
            fp.writelines(tweets_list[i])
    elif words[0] == "negative":
        if words[1] == '1':
            right += 1
        else:
            wrong += 1
            fp.writelines(tweets_list[i]) 
    else:
        pass

fp.close()
print "right is: ", right
print "wrong is: ", wrong

#output=zip(tweets_list,positive_counts,negative_counts)

#writer = csv.writer(open('tweet_sentiment.csv', 'wb'))
#writer.writerows(output)

