package main

import org.apache.spark.SparkContext
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.rdd.RDD
/**
  * A common train shared by all feature generators.
  * Allows a "training" phase followed by a generation phase
  * Created by Eric on 2/1/2017.
  */
trait FeatureGenerator {
  def train(tweets: RDD[Tweet]): Unit

  def generateFeatures(tweets: RDD[Tweet]): RDD[LabeledPoint]

  def saveGenerator(filePath: String, sc: SparkContext): Unit

  def loadGenerator(filePath: String, sc: SparkContext): Unit

}