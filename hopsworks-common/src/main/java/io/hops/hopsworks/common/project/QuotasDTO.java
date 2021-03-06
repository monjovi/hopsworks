/*
 * Copyright (C) 2013 - 2018, Logical Clocks AB and RISE SICS AB. All rights reserved
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS  OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL  THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR  OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package io.hops.hopsworks.common.project;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class QuotasDTO implements Serializable {

  private static final long serialVersionUID = -1L;

  private Long hdfsUsageInBytes = null;
  private Long hdfsQuotaInBytes = null;
  private Long hdfsNsCount = null;
  private Long hdfsNsQuota = null;
  private Long hiveHdfsUsageInBytes = null;
  private Long hiveHdfsQuotaInBytes = null;
  private Long hiveHdfsNsCount = null;
  private Long hiveHdfsNsQuota = null;
  private Float yarnQuotaInSecs = null;
  private Float yarnUsedQuotaInSecs = null;
  private Integer kafkaMaxNumTopics = null;

  public QuotasDTO() {
  }

  public QuotasDTO(Float yarnQuotaInSecs, Float yarnUsedQuotaInSecs,
                   Long hdfsQuotaInBytes, Long hdfsUsageInBytes,
                   Long hdfsNsQuota, Long hdfsNsCount,
                   Long hiveHdfsQuotaInBytes, Long hiveHdfsUsageInBytes,
                   Long hiveHdfsNsQuota, Long hiveHdfsNsCount, Integer kafkaMaxNumTopics) {
    this.yarnQuotaInSecs = yarnQuotaInSecs;
    this.yarnUsedQuotaInSecs = yarnUsedQuotaInSecs;
    this.hdfsQuotaInBytes = hdfsQuotaInBytes;
    this.hdfsUsageInBytes = hdfsUsageInBytes;
    this.hdfsNsQuota = hdfsNsQuota;
    this.hdfsNsCount = hdfsNsCount;
    this.hiveHdfsQuotaInBytes = hiveHdfsQuotaInBytes;
    this.hiveHdfsUsageInBytes = hiveHdfsUsageInBytes;
    this.hiveHdfsNsCount = hiveHdfsNsCount;
    this.hiveHdfsNsQuota = hiveHdfsNsQuota;
    this.kafkaMaxNumTopics = kafkaMaxNumTopics;
  }

  public QuotasDTO(Long hdfsQuotaInBytes, Long hdfsNsQuota,
                   Long hiveHdfsQuotaInBytes, Long hiveHdfsNsQuota, Float yarnQuotaInSecs, Integer numKafkaTopics) {
    this.hdfsQuotaInBytes = hdfsQuotaInBytes;
    this.hdfsNsQuota = hdfsNsQuota;
    this.hiveHdfsQuotaInBytes = hiveHdfsQuotaInBytes;
    this.hiveHdfsNsQuota = hiveHdfsNsQuota;
    this.yarnQuotaInSecs = yarnQuotaInSecs;
    this.kafkaMaxNumTopics = numKafkaTopics;
  }

  public Long getHdfsQuotaInBytes() {
    return hdfsQuotaInBytes;
  }

  public Float getYarnQuotaInSecs() {
    return yarnQuotaInSecs;
  }

  public void setHdfsQuotaInBytes(Long hdfsQuotaInBytes) {
    this.hdfsQuotaInBytes = hdfsQuotaInBytes;
  }

  public void setYarnQuotaInSecs(Float yarnQuotaInSecs) {
    this.yarnQuotaInSecs = yarnQuotaInSecs;
  }

  public Long getHdfsUsageInBytes() {
    return hdfsUsageInBytes;
  }

  public void setHdfsUsageInBytes(Long hdfsUsageInBytes) {
    this.hdfsUsageInBytes = hdfsUsageInBytes;
  }

  public Long getHdfsNsQuota() {
    return hdfsNsQuota;
  }

  public void setHdfsNsQuota(Long hdfsNsQuota) {
    this.hdfsNsQuota = hdfsNsQuota;
  }

  public Long getHdfsNsCount() {
    return hdfsNsCount;
  }

  public void setHdfsNsCount(Long hdfsNsCount) {
    this.hdfsNsCount = hdfsNsCount;
  }

  public Long getHiveHdfsUsageInBytes() {
    return hiveHdfsUsageInBytes;
  }

  public void setHiveHdfsUsageInBytes(Long hiveHdfsUsageInBytes) {
    this.hiveHdfsUsageInBytes = hiveHdfsUsageInBytes;
  }

  public Long getHiveHdfsQuotaInBytes() {
    return hiveHdfsQuotaInBytes;
  }

  public void setHiveHdfsQuotaInBytes(Long hiveHdfsQuotaInBytes) {
    this.hiveHdfsQuotaInBytes = hiveHdfsQuotaInBytes;
  }

  public Long getHiveHdfsNsCount() {
    return hiveHdfsNsCount;
  }

  public void setHiveHdfsNsCount(Long hiveHdfsNsCount) {
    this.hiveHdfsNsCount = hiveHdfsNsCount;
  }

  public Long getHiveHdfsNsQuota() {
    return hiveHdfsNsQuota;
  }

  public void setHiveHdfsNsQuota(Long hiveHdfsNsQuota) {
    this.hiveHdfsNsQuota = hiveHdfsNsQuota;
  }

  public Float getYarnUsedQuotaInSecs() {
    return yarnUsedQuotaInSecs;
  }

  public void setYarnUsedQuotaInSecs(Float yarnUsedQuotaInSecs) {
    this.yarnUsedQuotaInSecs = yarnUsedQuotaInSecs;
  }

  public Integer getKafkaMaxNumTopics() {
    return kafkaMaxNumTopics;
  }

  public void setKafkaMaxNumTopics(Integer kafkaMaxNumTopics) {
    this.kafkaMaxNumTopics = kafkaMaxNumTopics;
  }
  
  @Override
  public String toString() {
    return "QuotasDTO{" +
        "hdfsUsageInBytes=" + hdfsUsageInBytes +
        ", hdfsQuotaInBytes=" + hdfsQuotaInBytes +
        ", hdfsNsCount=" + hdfsNsCount +
        ", hdfsNsQuota=" + hdfsNsQuota +
        ", hiveHdfsUsageInBytes=" + hiveHdfsUsageInBytes +
        ", hiveHdfsQuotaInBytes=" + hiveHdfsQuotaInBytes +
        ", hiveHdfsNsCount=" + hiveHdfsNsCount +
        ", hiveHdfsNsQuota=" + hiveHdfsNsQuota +
        ", yarnQuotaInSecs=" + yarnQuotaInSecs +
        ", yarnUsedQuotaInSecs =" + yarnUsedQuotaInSecs +
        ", kafkaMaxNumTopics =" + kafkaMaxNumTopics +
        '}';
  }
}
