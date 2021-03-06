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

package io.hops.hopsworks.common.dao.log.meta;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import io.hops.hopsworks.common.dao.log.operation.OperationType;
import io.hops.hopsworks.common.dao.metadata.Metadata;
import io.hops.hopsworks.common.dao.metadata.MetadataPK;
import io.hops.hopsworks.common.dao.metadata.SchemalessMetadata;
import io.hops.hopsworks.common.dao.metadata.SchemalessMetadataPK;

@Entity
@Table(name = "hopsworks.meta_log")
public class MetaLog implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;

  @Basic(optional = false)
  @NotNull
  @Column(name = "meta_pk1")
  private Integer metaPk1;

  @Basic(optional = false)
  @NotNull
  @Column(name = "meta_pk2")
  private Integer metaPk2;

  @Basic(optional = false)
  @NotNull
  @Column(name = "meta_pk3")
  private Integer metaPk3;

  @Basic(optional = false)
  @NotNull
  @Column(name = "meta_type")
  private MetaType metaType;

  @Basic(optional = false)
  @NotNull
  @Column(name = "meta_op_type")
  private OperationType metaOpType;

  public MetaLog() {

  }

  public MetaLog(Metadata metaData, OperationType opType) {
    this.metaType = MetaType.SchemaBased;
    MetadataPK pk = metaData.getMetadataPK();
    this.metaPk1 = pk.getId();
    this.metaPk2 = pk.getFieldid();
    this.metaPk3 = pk.getTupleid();
    this.metaOpType = opType;
  }

  public MetaLog(SchemalessMetadata metaData, OperationType opType) {
    this.metaType = MetaType.SchemaLess;
    SchemalessMetadataPK pk = metaData.getPK();
    this.metaPk1 = pk.getId();
    this.metaPk2 = pk.getInodeId();
    this.metaPk3 = pk.getInodeParentId();
    this.metaOpType = opType;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMetaPk1() {
    return metaPk1;
  }

  public void setMetaPk1(Integer metaPk1) {
    this.metaPk1 = metaPk1;
  }

  public Integer getMetaPk2() {
    return metaPk2;
  }

  public void setMetaPk2(Integer metaPk2) {
    this.metaPk2 = metaPk2;
  }

  public Integer getMetaPk3() {
    return metaPk3;
  }

  public void setMetaPk3(Integer metaPk3) {
    this.metaPk3 = metaPk3;
  }

  public MetaType getMetaType() {
    return metaType;
  }

  public void setMetaType(MetaType metaType) {
    this.metaType = metaType;
  }

  public OperationType getMetaOpType() {
    return metaOpType;
  }

  public void setMetaOpType(OperationType metaOpType) {
    this.metaOpType = metaOpType;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 73 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final MetaLog other = (MetaLog) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

}
