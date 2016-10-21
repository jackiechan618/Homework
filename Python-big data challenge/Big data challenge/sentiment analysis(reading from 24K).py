#!/usr/bin/python
# -*- coding: utf-8 -*-
#from __future__ import division
import os
import sys
import numpy as np
from string import punctuation

##########################################################################################################
#     Function definition                                                                             
##########################################################################################################

# 2. Sentiment dictionary analysis basic function
# Function of matching adverbs of degree and set weights
def match(word, sentiment_value):
#    print word
    
    if word in mostdict:
        sentiment_value *= 2.0
#        print "2"
    elif word in verydict:
#        print "1.5"
        sentiment_value *= 1.5
    elif word in moredict:
#        print "1.25"
        sentiment_value *= 1.25
    elif word in ishdict:
#        print "0.5"
        sentiment_value *= 0.5
    elif word in insufficientdict:
#        print "0.25"
        sentiment_value *= 0.25
    elif word in inversedict:
  #      print "-1"
        sentiment_value *= -1
 #       print word
        
    return sentiment_value

# Function of transforming negative score to positive score
# Example: [5, -2] →  [7, 0]; [-4, 8] →  [0, 12]
def transform_to_positive_num(poscount, negcount):
    pos_count = 0
    neg_count = 0
    if poscount < 0 and negcount >= 0:
        neg_count += negcount - poscount
        pos_count = 0
    elif negcount < 0 and poscount >= 0:
        pos_count = poscount - negcount
        neg_count = 0
    elif poscount < 0 and negcount < 0:
        neg_count = -poscount
        pos_count = -negcount
    else:
        pos_count = poscount
        neg_count = negcount
    return [pos_count, neg_count]


# 3.1 Single review's positive and negative score
# Function of calculating review's every sentence sentiment score
def sumup_sentence_sentiment_score(score_list):
	score_array = np.array(score_list) # Change list to a numpy array
	Pos = np.sum(score_array[:,0]) # Compute positive score
	Neg = np.sum(score_array[:,1])

	return [Pos, Neg] #, AvgPos, AvgNeg, StdPos, StdNeg]

def single_review_sentiment_score(seg_sent):
    single_review_senti_score = []
#    punctuation_bits = []
    word_posit = 1 # word position counter for whole seg_sent
    group_start_bit = 0 # start position for each meaning group
    start_bit = 0 # sentiment word position
    stop_bit = 0 # word position counter for slice of seg_sent[a:i]
    poscount = 0 # count a positive score
    negcount = 0 # count a negative score
    pos_flag = 0
    neg_flag = 0

    for word in seg_sent:  
        # seperate into different meaning group          
        if word == "and" or word == "or" or word in list(punctuation): 
            start_bit = stop_bit = group_start_bit                                                
            for x in seg_sent[ group_start_bit : word_posit ]:
                stop_bit += 1                                    
                if x in posdict:
 #                   print x
                    poscount += 1
                    pos_flag = 1
                    neg_flag = 0
                    for w in seg_sent[start_bit:word_posit]:
                        poscount = match(w, poscount)
                    start_bit = stop_bit + 1
                elif x in negdict:
                    negcount += 1
                    pos_flag = 0
                    neg_flag = 1
                    for w in seg_sent[start_bit:word_posit]:
                        negcount = match(w, negcount)
                    start_bit = stop_bit + 1
                elif stop_bit == word_posit:                
                    if pos_flag == 1:
                        for w in seg_sent[start_bit:word_posit]:
                            poscount = match(w, poscount)
                    elif neg_flag == 1:
                        for w in seg_sent[start_bit:word_posit]:
                            negcount = match(w, negcount)
            
            group_start_bit = word_posit + 1
            pos_flag = 0
            neg_flag = 0
             # if one meaning group has negative words, it means positive sentiment even if having positive words
            if negcount > 0:
                poscount = 0
#            print poscount
#            print negcount    
        # arriving at the end of the seg_sent
        elif word_posit == len(seg_sent): 
            start_bit = stop_bit = group_start_bit 
            for x in seg_sent[ group_start_bit : word_posit ]:
                stop_bit += 1                                    
                if x in posdict:
 #                   print x
                    poscount += 1
                    pos_flag = 1
                    neg_flag = 0
                    for w in seg_sent[start_bit:word_posit]:
                        poscount = match(w, poscount)
                    start_bit = stop_bit + 1
                elif x in negdict:
                    negcount += 1
                    pos_flag = 0
                    neg_flag = 1
                    for w in seg_sent[start_bit:word_posit]:
                        negcount = match(w, negcount)
                    start_bit = stop_bit + 1
                elif stop_bit == word_posit:                
                   if pos_flag == 1:
                       for w in seg_sent[start_bit:word_posit]:
                           poscount = match(w, poscount)
                   elif neg_flag == 1:
                       for w in seg_sent[start_bit:word_posit]:
                           negcount = match(w, negcount)
             
     
            # if one meaning group has negative words, it means positive sentiment even if having positive words
            if negcount > 0:
                poscount = 0
#            print poscount
#            print negcount
        
        word_posit += 1
       
        single_review_senti_score.append(transform_to_positive_num(poscount, negcount))
        review_sentiment_score = sumup_sentence_sentiment_score(single_review_senti_score)
    
    return review_sentiment_score
    
def review_sentiment_analysis(review):
        
    ##########################################################################################################
    #     Sentiment analysis and output                                                                         
    ##########################################################################################################
    
    tweet_processed=review.lower()
    tweet_processed=tweet_processed.replace("'",'')
    tweet_processed=tweet_processed.replace('"','')
    
    for p in list(punctuation):
        temp_str=' '+p
        tweet_processed=tweet_processed.replace(p,temp_str)
              
    tweet_processed=tweet_processed.replace("1",'')
    tweet_processed=tweet_processed.replace("5",'')
    tweet_processed=tweet_processed.replace("\t",'')
    tweet_processed=tweet_processed.replace("\r",'')
    
    words=tweet_processed.split(' ')
    sentiment_score = single_review_sentiment_score(words)
    
    
    if sentiment_score[0] > sentiment_score[1]:
#        print "positive"
#        print sentiment_score[0]
        return 'positive'

    elif sentiment_score[0] <= sentiment_score[1]:
 #       print "negative"
 #       print sentiment_score[1]
        return 'negative'

        
    
##########################################################################################################
#     Documents reading                                                                             
##########################################################################################################

filelist=['negative.txt','positive.txt','mostdict.txt', 'verydict.txt', 'moredict.txt','ishdict.txt','insufficientdict.txt','inversedict.txt','stopwords.txt','24kData2.txt']

for num in range(0, 10):
    filelist[num] = os.path.join(os.getcwd(), filelist[num]) 

negative_word = file(filelist[0], "r").read()
negative_word=negative_word.replace("\r",'')
negdict = negative_word.split('\n')


positive_word = file(filelist[1], "r").read()
positive_word=positive_word.replace("\r",'')
posdict = positive_word.split('\n')


most_word = file(filelist[2], "r").read()
most_word=most_word.replace("\r",'')
mostdict = most_word.split('\n')


very_word = file(filelist[3], "r").read()
very_word=very_word.replace("\r",'')
verydict = very_word.split('\n')


more_word = file(filelist[4], "r").read()
more_word=more_word.replace("\r",'')
moredict = more_word.split('\n')


ish_word = file(filelist[5], "r").read()
ish_word=ish_word.replace("\r",'')
ishdict = ish_word.split('\n')


insufficient_word = file(filelist[6], "r").read()
insufficient_word=insufficient_word.replace("\r",'')
insufficientdict = insufficient_word.split('\n')

inverse_word=file(filelist[7],"r").read()
inverse_word=inverse_word.replace("\r",'')
inversedict=inverse_word.split('\n')

stopwords_contain = file(filelist[8], "r").read()
stopwords_list = stopwords_contain.split(',')

recommend_contain = file(filelist[9], "r").read()
recommend_list = recommend_contain.split('\n')



##########################################################################################################
#     Documents processing                                                                            
##########################################################################################################    

for i in range(0, len(recommend_list)):  
    recommend_list[i] = review_sentiment_analysis(recommend_list[i]) + ' ' + recommend_list[i] + "\n"
fp = file(os.path.join(os.getcwd(), "output.txt"), "w")
fp.writelines(recommend_list)
fp.close()






   




        






