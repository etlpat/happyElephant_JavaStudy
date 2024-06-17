package com.leetcode_2024_03_05.test2_$$$;

//    TODO 2040. 两个有序数组的第 K 小乘积
//
//    给你两个 从小到大排好序 且下标从 0 开始的整数数组 nums1 和 nums2 以及一个整数 k ，
//    请你返回第 k （从 1 开始编号）小的 nums1[i] * nums2[j] 的乘积，
//    其中 0 <= i < nums1.length 且 0 <= j < nums2.length 。
//
//
//    示例 1：
//    输入：nums1 = [2,5], nums2 = [3,4], k = 2
//    输出：8
//    解释：第 2 小的乘积计算如下：
//    - nums1[0] * nums2[0] = 2 * 3 = 6
//    - nums1[0] * nums2[1] = 2 * 4 = 8
//    第 2 小的乘积为 8 。
//
//    示例 2：
//    输入：nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
//    输出：-6
//    解释：第 3 小的乘积计算如下：
//    - nums1[0] * nums2[4] = (-2) * 5 = -10
//    - nums1[0] * nums2[3] = (-2) * 4 = -8
//    - nums1[4] * nums2[0] = 2 * (-3) = -6
//    第 3 小的乘积为 -6 。
//
//
//    提示：
//    1 <= nums1.length, nums2.length <= 5 * 104
//    -105 <= nums1[i], nums2[j] <= 105
//    1 <= k <= nums1.length * nums2.length
//    nums1 和 nums2 都是从小到大排好序的。


public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {2, 5};
        int[] arr2 = {3, 4};
        System.out.println(solution.kthSmallestProduct(arr1, arr2, 2));// 8

        int[] arr3 = {-2,-1,0,1,2};
        int[] arr4 = {-3,-1,2,4,5};
        System.out.println(solution.kthSmallestProduct(arr3, arr4, 3));// -6

        int[] arr5 = {-100000,100000};
        int[] arr6 = {-100000,100000};
        System.out.println(solution.kthSmallestProduct(arr5, arr6, 1));// -10000000000

        int[] arr7 = {-9,6,10};
        int[] arr8 = {-7,-1,1,2,3,4,4,6,9,10};
        System.out.println(solution.kthSmallestProduct(arr7, arr8, 15));// 10

        int[] arr9 = {-3,6,8,10};
        int[] arr10 = {-2};
        System.out.println(solution.kthSmallestProduct(arr9, arr10, 3));// -12

        int[] arr11 = {-8,-7,-5,0,1,3,5,6,7,10};
        int[] arr12 = {2,3,5,10};
        System.out.println(solution.kthSmallestProduct(arr11, arr12, 24));// 12

//        int[] arr13 = {-500,-493,-492,-490,-489,-485,-483,-482,-480,-479,-478,-470,-467,-465,-464,-463,-462,-462,-461,-461,-459,-458,-457,-457,-456,-454,-451,-451,-451,-448,-448,-446,-444,-443,-440,-436,-434,-434,-433,-432,-431,-430,-429,-427,-425,-424,-421,-419,-416,-414,-413,-412,-412,-409,-408,-406,-405,-405,-404,-402,-398,-397,-397,-396,-396,-394,-393,-392,-390,-387,-386,-386,-385,-384,-381,-381,-380,-376,-374,-374,-374,-373,-372,-372,-372,-369,-366,-365,-365,-364,-363,-361,-358,-358,-355,-355,-355,-354,-354,-348,-348,-347,-346,-345,-344,-343,-342,-341,-337,-337,-335,-334,-332,-331,-327,-326,-325,-325,-323,-319,-318,-317,-315,-313,-309,-308,-307,-302,-302,-301,-300,-300,-299,-298,-298,-297,-297,-295,-293,-284,-279,-278,-276,-274,-271,-271,-270,-268,-267,-266,-264,-262,-259,-259,-258,-257,-256,-252,-252,-251,-247,-245,-245,-245,-244,-243,-240,-239,-237,-236,-234,-233,-231,-230,-229,-228,-227,-227,-225,-223,-221,-220,-219,-218,-218,-216,-214,-212,-211,-208,-208,-208,-207,-204,-204,-203,-202,-200,-200,-199,-197,-196,-195,-194,-189,-189,-181,-179,-178,-176,-172,-172,-170,-169,-167,-166,-162,-162,-161,-157,-151,-149,-146,-144,-143,-141,-141,-139,-137,-136,-134,-134,-132,-130,-129,-128,-124,-124,-119,-117,-117,-116,-115,-115,-115,-112,-111,-110,-108,-108,-107,-106,-101,-101,-100,-94,-94,-92,-91,-88,-86,-84,-83,-76,-72,-71,-69,-69,-63,-63,-60,-58,-57,-56,-55,-55,-54,-50,-50,-47,-47,-45,-40,-36,-34,-33,-31,-27,-24,-21,-21,-19,-19,-15,-15,-14,-8,-8,-7,-6,-5,-3,2,3,3,4,9,9,10,14,14,14,17,18,19,19,20,23,24,26,27,28,30,32,35,35,36,38,38,41,43,44,48,49,50,51,52,53,55,56,57,62,67,68,68,68,69,72,74,75,77,78,79,81,90,92,97,98,101,104,105,108,109,110,112,122,124,125,126,128,132,132,132,133,138,139,140,146,146,147,147,152,156,161,166,166,167,169,170,172,173,174,174,177,177,182,185,186,189,189,190,192,192,194,195,198,199,201,202,207,208,208,214,214,215,216,218,218,219,219,220,220,224,225,225,226,227,227,228,229,231,231,232,234,235,238,239,240,240,242,247,250,251,254,255,258,258,258,258,260,261,262,264,267,267,268,276,279,280,282,282,284,284,289,291,294,300,300,300,302,302,303,304,305,307,308,309,310,310,315,315,315,317,317,319,322,326,326,327,327,327,332,332,333,334,336,337,337,337,339,339,339,343,344,345,347,349,354,354,358,358,360,362,371,372,377,380,381,383,389,391,392,394,395,396,397,402,406,406,411,413,414,417,421,423,425,428,429,430,430,433,438,439,440,441,442,443,446,448,451,451,451,451,452,453,458,460,461,464,471,475,478,486,492,493,497,497,497,497,498,499};
//        int[] arr14 = {-498,-496,-496,-496,-493,-490,-490,-489,-488,-485,-485,-483,-481,-480,-480,-479,-479,-478,-477,-474,-471,-470,-469,-469,-468,-468,-467,-466,-464,-463,-463,-461,-459,-459,-458,-456,-455,-453,-451,-450,-449,-448,-448,-445,-438,-436,-435,-435,-435,-434,-434,-433,-433,-432,-432,-427,-425,-425,-424,-424,-424,-423,-422,-421,-421,-420,-419,-419,-418,-418,-417,-415,-415,-415,-414,-412,-409,-408,-408,-407,-407,-404,-404,-400,-398,-397,-397,-397,-395,-393,-391,-391,-390,-386,-386,-385,-385,-385,-383,-382,-380,-378,-377,-377,-376,-376,-376,-376,-375,-375,-375,-375,-373,-373,-373,-372,-367,-366,-366,-365,-364,-364,-364,-363,-362,-362,-360,-359,-359,-359,-355,-355,-353,-350,-349,-349,-348,-348,-347,-347,-345,-344,-344,-344,-343,-342,-342,-341,-339,-339,-339,-337,-334,-334,-331,-331,-331,-330,-330,-329,-328,-328,-326,-324,-324,-324,-322,-320,-319,-318,-317,-317,-316,-315,-314,-311,-311,-310,-310,-308,-307,-306,-306,-306,-305,-304,-303,-302,-301,-299,-299,-297,-296,-295,-295,-294,-293,-291,-289,-289,-288,-286,-285,-284,-281,-280,-278,-277,-277,-276,-276,-275,-274,-272,-272,-272,-271,-271,-270,-269,-268,-265,-265,-264,-263,-261,-261,-259,-256,-256,-255,-255,-255,-254,-253,-252,-252,-251,-250,-247,-247,-246,-246,-244,-243,-242,-241,-241,-241,-241,-239,-237,-237,-234,-233,-232,-231,-230,-228,-227,-226,-225,-223,-223,-223,-223,-222,-222,-219,-218,-216,-215,-215,-214,-214,-214,-213,-211,-211,-211,-210,-209,-207,-205,-205,-204,-202,-201,-201,-200,-199,-198,-198,-198,-197,-196,-196,-194,-193,-192,-190,-190,-189,-189,-187,-186,-186,-185,-185,-181,-180,-180,-179,-178,-177,-176,-176,-174,-173,-173,-172,-172,-170,-169,-169,-168,-168,-167,-166,-165,-164,-161,-161,-161,-159,-158,-156,-155,-154,-154,-153,-152,-151,-151,-150,-150,-150,-148,-148,-147,-146,-144,-141,-141,-141,-140,-139,-138,-137,-137,-137,-137,-135,-134,-133,-131,-131,-130,-129,-128,-128,-127,-126,-123,-123,-120,-118,-117,-117,-116,-114,-113,-113,-113,-113,-108,-106,-106,-105,-104,-102,-102,-102,-100,-100,-100,-98,-96,-94,-93,-93,-92,-92,-91,-90,-89,-88,-87,-86,-85,-84,-84,-84,-83,-83,-82,-82,-81,-81,-79,-79,-76,-76,-75,-74,-74,-73,-73,-73,-72,-72,-68,-68,-67,-67,-62,-60,-60,-58,-57,-57,-57,-55,-55,-52,-46,-44,-41,-41,-40,-39,-37,-36,-32,-32,-31,-31,-31,-30,-30,-30,-29,-28,-27,-26,-26,-21,-20,-17,-17,-16,-15,-14,-14,-14,-13,-12,-11,-10,-10,-7,-6,-4,-3,-1,0,0,1,4,5,6,6,7,7,9,9,11,12,13,14,18,19,19,20,22,22,22,22,24,24,25,25,27,27,29,32,33,33,33,34,34,35,36,36,37,37,38,38,39,39,40,41,42,44,48,48,49,49,49,50,50,52,54,54,57,59,59,60,66,67,68,68,69,71,73,74,75,75,75,76,77,77,77,79,80,83,83,85,85,87,87,88,88,89,91,92,94,97,97,98,99,99,101,101,101,102,103,103,103,104,105,105,106,106,106,107,107,107,109,110,110,111,111,112,113,113,115,115,118,119,120,121,121,122,124,125,127,128,128,129,130,131,131,137,137,138,140,141,146,146,148,153,154,157,159,159,160,160,160,161,163,165,165,167,169,171,172,172,172,172,175,176,177,177,177,178,178,179,180,181,183,184,185,186,186,190,191,192,192,192,193,195,198,199,199,202,203,204,204,205,206,207,207,210,211,211,212,212,214,214,215,216,216,217,218,220,221,222,223,225,227,229,229,230,230,230,231,231,232,232,234,235,236,238,238,240,240,241,243,244,244,246,247,248,248,251,253,253,255,256,256,257,257,259,260,261,261,264,264,265,270,271,272,273,277,278,279,280,281,281,282,284,286,286,286,286,287,288,288,289,289,290,292,292,294,294,298,299,299,299,300,300,303,303,304,304,305,305,306,306,310,310,310,311,315,316,316,316,316,317,317,319,321,321,321,321,323,330,335,336,336,338,340,341,343,343,344,345,345,345,347,348,348,350,353,356,358,358,358,362,362,364,366,368,368,368,370,371,371,372,372,373,374,378,379,381,382,383,383,383,384,385,385,385,387,387,389,392,392,392,393,393,394,395,395,397,398,399,401,402,402,402,403,406,406,406,407,410,410,410,412,413,413,413,415,417,419,421,421,423,424,424,426,427,427,428,429,431,434,437,438,440,443,443,444,444,446,446,448,449,450,452,452,455,455,456,457,459,459,459,460,460,460,461,462,463,464,467,470,471,471,473,474,475,476,477,477,479,480,481,482,482,482,483,483,484,485,485,486,487,488,489,490,491,492,493,495,495,496,497,498,499,500,500,500,500,500};
//        System.out.println(solution.kthSmallestProduct(arr13, arr14, 107136));// -65853

//        int[] arr15 = {-500,-499,-498,-498,-496,-494,-493,-493,-491,-491,-490,-490,-489,-488,-487,-487,-482,-482,-479,-476,-475,-475,-475,-474,-474,-473,-472,-469,-468,-466,-465,-462,-460,-455,-454,-454,-453,-453,-450,-448,-448,-444,-440,-440,-437,-437,-436,-435,-435,-434,-429,-425,-425,-424,-420,-419,-418,-417,-417,-415,-415,-412,-411,-410,-406,-406,-405,-400,-399,-398,-388,-386,-386,-385,-384,-383,-377,-371,-369,-366,-364,-363,-362,-362,-360,-359,-359,-358,-358,-357,-356,-355,-354,-353,-352,-349,-348,-347,-345,-345,-344,-344,-343,-331,-329,-326,-320,-319,-314,-314,-312,-310,-308,-307,-305,-301,-300,-300,-295,-293,-292,-290,-289,-289,-288,-285,-283,-282,-282,-281,-280,-280,-278,-276,-275,-271,-270,-269,-266,-264,-263,-262,-256,-256,-256,-256,-255,-252,-250,-249,-248,-246,-245,-243,-243,-242,-241,-241,-239,-238,-237,-235,-234,-231,-230,-228,-226,-226,-223,-223,-223,-220,-219,-219,-217,-216,-210,-209,-204,-204,-204,-203,-202,-201,-198,-197,-195,-194,-187,-186,-186,-183,-180,-176,-175,-172,-168,-166,-162,-162,-161,-157,-155,-155,-151,-150,-148,-146,-145,-142,-142,-142,-141,-140,-138,-135,-133,-129,-128,-126,-126,-126,-124,-123,-121,-121,-120,-119,-117,-116,-115,-114,-110,-107,-106,-105,-103,-103,-103,-101,-93,-92,-91,-89,-80,-75,-74,-70,-68,-64,-61,-53,-52,-51,-50,-49,-48,-47,-43,-42,-41,-40,-39,-34,-34,-33,-33,-33,-33,-31,-30,-29,-23,-22,-21,-20,-19,-16,-15,-13,-12,-12,-11,-8,-7,-5,-5,-3,-1,0,3,5,6,7,13,21,23,26,28,28,28,34,35,36,39,39,40,40,41,49,50,53,53,54,54,55,58,62,63,64,65,69,74,75,76,76,78,80,80,81,84,85,87,87,88,91,91,92,94,95,96,97,100,100,101,102,103,103,104,104,105,108,109,113,116,116,118,118,119,121,124,125,125,127,129,129,134,135,136,137,140,140,144,144,144,145,148,148,149,149,149,152,153,154,157,161,162,162,162,164,171,181,186,186,191,194,195,195,198,201,203,204,205,210,210,213,215,216,219,219,221,223,223,225,229,229,232,233,234,238,239,240,240,243,243,247,250,253,253,255,255,257,259,261,264,265,266,268,268,269,270,271,274,274,277,278,278,280,283,286,294,297,297,301,303,304,304,306,307,310,310,311,312,312,312,313,315,316,317,318,321,322,327,329,330,330,331,332,335,338,341,342,343,348,350,353,354,355,358,361,363,363,365,367,371,372,375,376,376,377,377,378,379,380,380,381,382,385,386,387,387,388,389,391,392,393,394,394,395,396,398,399,400,402,403,405,406,407,409,411,411,415,416,420,421,421,421,424,425,429,431,432,436,437,438,438,439,442,442,444,445,446,446,447,450,451,452,453,456,460,462,463,463,464,466,467,469,470,473,477,478,479,479,484,484,485,485,486,491,491,492,493,493,494,494,496,496,497,498,499,499};
//        int[] arr16 = {-495,-487,-485,-483,-483,-482,-472,-465,-464,-464,-460,-454,-451,-450,-450,-449,-443,-442,-440,-438,-436,-436,-435,-433,-432,-431,-428,-426,-424,-422,-419,-418,-416,-416,-416,-416,-415,-414,-413,-409,-406,-403,-401,-400,-398,-392,-390,-389,-385,-385,-378,-372,-369,-369,-359,-349,-348,-340,-339,-335,-335,-335,-334,-330,-328,-323,-321,-298,-296,-295,-295,-295,-295,-291,-287,-287,-286,-282,-282,-277,-277,-276,-276,-274,-274,-270,-268,-267,-267,-262,-260,-258,-256,-255,-252,-252,-250,-248,-246,-245,-243,-240,-237,-236,-235,-235,-230,-230,-229,-229,-228,-227,-209,-209,-205,-204,-201,-198,-197,-195,-193,-192,-189,-185,-184,-181,-179,-178,-175,-174,-171,-171,-170,-165,-163,-163,-157,-153,-149,-147,-146,-145,-145,-143,-142,-141,-140,-137,-133,-131,-129,-128,-126,-125,-125,-125,-123,-123,-122,-120,-117,-114,-113,-110,-109,-106,-105,-92,-89,-88,-87,-87,-85,-82,-77,-76,-74,-68,-67,-67,-65,-64,-57,-54,-54,-53,-51,-46,-44,-39,-38,-36,-28,-27,-11,-10,-9,-9,-9,-7,-3,-2,-1,-1,2,3,7,8,10,13,14,18,23,27,28,29,29,29,29,31,33,33,37,37,38,39,42,45,46,52,53,53,57,62,67,77,78,79,80,81,86,90,91,92,92,100,100,103,106,107,113,115,117,119,120,121,127,129,133,134,136,136,137,138,138,141,142,142,143,143,144,145,145,149,151,154,156,158,160,166,167,168,171,174,187,189,191,192,193,193,194,194,194,198,205,206,207,207,208,208,209,209,209,211,217,218,222,223,223,224,225,235,237,239,246,247,247,247,250,255,256,262,270,270,273,274,274,275,275,277,277,284,285,285,288,289,290,292,293,294,294,295,298,299,300,301,302,303,305,313,313,323,325,327,335,336,342,343,344,348,348,357,359,364,365,367,370,370,371,375,375,377,377,379,379,381,383,384,385,387,390,391,396,396,397,399,400,401,405,411,415,415,418,420,424,424,428,430,431,436,437,439,441,444,447,447,451,456,460,466,469,470,470,470,471,474,475,482,483,483,483,485,486,489,499};
//        System.out.println(solution.kthSmallestProduct(arr15, arr16, 89651));// -21528
    }
}
