package com.dondapati.solr.client

import org.apache.log4j.Logger
import org.apache.solr.client.solrj.impl.CloudSolrClient
import org.apache.solr.client.solrj.request.CollectionAdminRequest


object SolrCloudClient extends Serializable {

  def createConnection(solrCloudClient: CloudSolrClient,SOLR_READ_ALIAS:String) = {
    val collection = CloudSolrClient.
  }

  def setZooKeeperTimeout(solrCloudClient: CloudSolrClient) = {
    solrCloudClient.setZkClientTimeout(10000 * 10)
    solrCloudClient.setZkConnectTimeout(10000 * 10)
    solrCloudClient.connect()
  }

  def getCollectionFromAlias(solrCloudClient: CloudSolrClient,alias: String) = {
    val map = solrCloudClient.getZkStateReader.getAliases().getCollectionAliasMap()
    map.get(alias)
  }

  def deleteAlias (solrCloudClient: CloudSolrClient,alias: String) = {
    val response = CollectionAdminRequest.deleteAlias(alias).process(solrCloudClient)
  }

  def createOrupdateAlias(solrCloudClient: CloudSolrClient,alias: String,collection: String) = {
    val response = CollectionAdminRequest.createAlias(alias,collection).process(solrCloudClient)
  }

  val logger = Logger.getLogger(this.getClass)

}
