/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
import React, { useState, useEffect } from "react";
import { Toggle } from "carbon-components-react";
import CardViewChildrenNavigation from "./CardViewChildrenNavigation";
import { withRouter } from "react-router-dom";
/**
 * This is a card view of Categories
 */
const GlossaryAuthorCategoriesNavigation = (props) => {

  const [isCategoryAll, setIsCategoryAll] = useState(false);
  const onToggleTop = () => {
    console.log("onToggleTop");
    if (isCategoryAll) {
      setIsCategoryAll(false);
    } else {
      setIsCategoryAll(true);
    }
  };

  return (
    <div>
      <Toggle
        aria-label="topCategorytoggle"
        defaultToggled
        labelA="All Categories"
        labelB="Top Categories"
        id="category-filter-toggle"
        onToggle={onToggleTop}
      />
      <CardViewChildrenNavigation
        nodeTypeName="category"
        match={props.match}
        getURLForChildren={props.getCategoriesURL}
        isCategoryAll={isCategoryAll}
      />
    </div>
  );
}
export default withRouter(GlossaryAuthorCategoriesNavigation);